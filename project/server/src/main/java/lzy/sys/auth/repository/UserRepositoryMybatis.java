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
            " FROM user_role " +
            " LEFT JOIN role_permission ON role_permission.role_id = user_role.role_id"+
            " LEFT JOIN permission ON permission.id = role_permission.permission_id"+
            " WHERE "+
            " user_role.user_id=#{id} "+
            " GROUP BY permission.name "
    )
    List<String> findPermissions(@Param("id") Long id);

}
