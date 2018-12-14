package lzy.sys.auth.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * User: longzhiyou
 * Date: 2016/11/8
 * Time: 20:04
 */
@Mapper
public interface UserRepositoryMybatis  {

    @Select("SELECT " +
            "permission.name" +
            " FROM role_user " +
            " LEFT JOIN permission_role ON permission_role.role_id = role_user.role_id"+
            " LEFT JOIN permission ON permission.id = permission_role.permission_id"+
            " WHERE "+
            " role_user.user_id=#{id} "+
            " GROUP BY permission.name "
    )
    List<String> findPermissions(@Param("id") Long id);

}
