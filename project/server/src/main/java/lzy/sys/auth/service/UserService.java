package lzy.sys.auth.service;

import lzy.common.exception.UnauthorizedException;
import lzy.sys.auth.domain.RegisterUser;
import lzy.sys.auth.domain.UserInfo;
import lzy.sys.auth.entity.Permission;
import lzy.sys.auth.entity.Role;
import lzy.sys.auth.entity.User;
import lzy.sys.auth.repository.UserRepository;
import lzy.sys.auth.repository.UserRepositoryMybatis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 系统认证服务
 * User: longzhiyou
 * Date: 2016/11/21
 * Time: 10:18
 */
@Service
@Transactional()
public class UserService {


    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

//    @Autowired
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private UserRepositoryMybatis userRepositoryMybatis;



//    User register(User userToAdd);
//    String login(String username, String password);
//    String refresh(String oldToken);


    //将缓存保存进andCache，并使用参数中的bid加上一个字符串(这里使用方法名称)作为缓存的key
//    @Cacheable(value="userCache",key="#username+'findUser'")
    public UserInfo findUser(String username){

        User user = userRepository.findFirstByUsername(username);
        if (null==user) {
            return null;
        }

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(user.getUsername());
        userInfo.setPassword(user.getPassword());
        userInfo.setEnabled(user.getEnabled());

        Collection<GrantedAuthority> grantedAuthorities = new HashSet<>();

        //不重复的字符串
        Set<String> authorities =  new HashSet<>();
        Set<Role> roles = user.getRoles();

           for (Role role: roles){
               authorities.add(role.getName());

               Set<Permission> permissions = role.getPermissions();
               for (Permission permission: permissions){
                   authorities.add(permission.getName());
               }

           }

//        List<String> permissions = userRepositoryMybatis.findPermissions(user.getUserId());
        for (String permission : authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(permission));
        }

        logger.info("【authorities】"+grantedAuthorities.toString());
        userInfo.setAuthorities(grantedAuthorities);

        return userInfo;
    }

//    @Cacheable(value="andCache",key="#user.username+'findPermission'")
    public List<String> findPermission(User user){

        List<String> permissions = userRepositoryMybatis.findPermissions(user.getUserId());
        return permissions;
    }


    //清除掉全部缓存
//    @CacheEvict(value="andCache",allEntries=true,beforeInvocation=true)
    //清除掉指定key中的缓存
    @CacheEvict(value="userCache",key="#user.username + 'findUser'")
    public UserInfo addUser(RegisterUser user){

//        log.info("清除指定缓存"+user.getUsername()+"findFirstByUsername");

        //验证序列号
//        if (!LicenseGenerator.matches(user.getLicense())){
//            throw new UnauthorizedException("序列号不正确");
//        }
        User entity = userRepository.findFirstByUsername(user.getUsername());
        if (null!=entity) {
          throw new UnauthorizedException("用户名已存在");
        }


      User userEntity = new User();
      userEntity.setEnabled(true);
      userEntity.setUsername(user.getUsername());
      BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
      userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
      User save = userRepository.save(userEntity);

      UserInfo info = new UserInfo();
      BeanUtils.copyProperties(save,info);
//      info.setEnabled(save.getEnabled());
//      info.setUsername(save.getUsername());
//      info.setId(save.getId());
      return info;


    }



}
