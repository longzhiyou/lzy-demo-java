package lzy.sys.auth.repository;

import lzy.sys.auth.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User: longzhiyou
 * Date: 2016/11/8
 * Time: 20:04
 */

public interface PermissionRepository extends JpaRepository<Permission, Long> {


}
