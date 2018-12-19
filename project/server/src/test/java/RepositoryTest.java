import lzy.Application;
import lzy.demo.Book;
import lzy.demo.BookRepository;
import lzy.demo.Publisher;
import lzy.demo.PublisherRepository;
import lzy.sys.auth.entity.Permission;
import lzy.sys.auth.entity.Role;
import lzy.sys.auth.entity.User;
import lzy.sys.auth.repository.PermissionRepository;
import lzy.sys.auth.repository.RoleRepository;
import lzy.sys.auth.repository.UserRepository;
import lzy.sys.auth.repository.UserRepositoryMybatis;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User: longzhiyou
 * Date: 2017/10/23
 * Time: 19:03
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.NONE, classes = Application.class)
public class RepositoryTest {

    Logger logger = LoggerFactory.getLogger(RepositoryTest.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;


    @Autowired
    PermissionRepository permissionRepository;




    @Autowired
    private UserRepositoryMybatis userRepositoryMybatis;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void deleteUser(){
        User one = userRepository.findOne(1074593763382263808L);
        roleRepository.delete(one.getRoles());
        userRepository.delete(one);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void updateUserRole(){
        User one = userRepository.findOne(1074593763520675840L);
        one.setRoles(null);
        userRepository.save(one);

//        roleRepository.delete(1074591345483448320L);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void deleteRole(){
        roleRepository.delete(1074591345483448320L);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void deletePermission(){
        permissionRepository.delete(1074591345558945792L);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void initPermission(){


        //新增两个用户 1.longzhiyou 2.lzy
        User longzhiyou = new User();
        longzhiyou.setUsername("admin");

        User lzy = new User();
        lzy.setUsername("user");

        userRepository.save(longzhiyou);
        userRepository.save(lzy);

        //角色 user admin manager
        Role role1 = new Role();
        role1.setName("user");
        roleRepository.save(role1);
        Role role2 = new Role();
        role2.setName("admin");
        roleRepository.save(role2);
        Role role3 = new Role();
        role3.setName("manager");
        roleRepository.save(role3);


        //权限
        Permission permission = new Permission();
        permission.setName("P_ACCOUNT");
        permissionRepository.save(permission);

        Permission permission1 = new Permission();
        permission1.setName("P_ACCOUNT_C");
        permissionRepository.save(permission1);

        Permission permission2 = new Permission();
        permission2.setName("P_ACCOUNT_R");
        permissionRepository.save(permission2);


        Permission permission3 = new Permission();
        permission3.setName("P_ACCOUNT_U");
        permissionRepository.save(permission3);

        Permission permission4 = new Permission();
        permission4.setName("P_ACCOUNT_D");
        permissionRepository.save(permission4);

        Set<Permission> permissions = new HashSet<>();
        permissions.add(permission);
        permissions.add(permission2);
        role1.setPermissions(permissions);

        Set<Permission> permissions1 = new HashSet<>();
        permissions1.add(permission);
        permissions1.add(permission1);
        permissions1.add(permission2);
        permissions1.add(permission3);
        permissions1.add(permission4);
        role2.setPermissions(permissions1);


        Set<Role> roles = new HashSet<>();
        roles.add(role1);
        lzy.setRoles(roles);
        userRepository.save(lzy);

        Set<Role> roles1 = new HashSet<>();
        roles1.add(role2);
        roles1.add(role3);
        longzhiyou.setRoles(roles1);
        userRepository.save(longzhiyou);





//        User one = userRepository.findOne(2L);
//
//        Set<Role> roles = one.getRoles();
//
//       for (Role role: roles){
//           Set<Permission> permissions = role.getPermissions();
//
//
//       }
//
//
//        logger.info(one.toString());
    }


    @Test
    @Transactional
//    @Rollback(false)
    public void book(){
        // save a couple of books®
        final Publisher publisherA = new Publisher("Publisher A");
        final Publisher publisherB = new Publisher("Publisher B");
        final Publisher publisherC = new Publisher("Publisher C");

        bookRepository.save(new HashSet<Book>(){{
            add(new Book("Book A", new HashSet<Publisher>(){{
                add(publisherA);
                add(publisherB);
            }}));

            add(new Book("Book B", new HashSet<Publisher>(){{
                add(publisherA);
                add(publisherC);
            }}));
        }});

        // fetch all books
        for(Book book : bookRepository.findAll()) {
            logger.info(book.toString());
        }

        // save a couple of publishers
        final Book bookA = new Book("Book A");
        final Book bookB = new Book("Book B");

        publisherRepository.save(new HashSet<Publisher>() {{
            add(new Publisher("Publisher A", new HashSet<Book>() {{
                add(bookA);
                add(bookB);
            }}));

            add(new Publisher("Publisher B", new HashSet<Book>() {{
                add(bookA);
                add(bookB);
            }}));
        }});

        // fetch all publishers
        for(Publisher publisher : publisherRepository.findAll()) {
            logger.info(publisher.toString());
        }
    }

    @Test
    @Transactional
//    @Rollback(false)
    public void filterDevice(){

//        userRepository.findFirstByUsername("admin");
//        List<String> permissions = userRepositoryMybatis.findPermissions((long) 2);

//        logger.info(permissions.toString());

//        ClientApp clientApp = new ClientApp();
//
//        clientApp.setAppId("2");
//        clientApp.setAppName("test");
//        clientAppRepository.save(clientApp);
////
//        ClientApp one = clientAppRepository.getOne(1);
//        List<ClientApp> all = clientAppRepository.findAll();
//
//
//        assertNotNull(one);

    }

}