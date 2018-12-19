package lzy.common.domain;


/**
 * 权限定义类
 * User: longzhiyou
 * Date: 2018/12/14
 * Time: 13:39
 */
public interface GrantedAuthorityDefine {

    //    @Secured({"P_DELETED"})
    //    @PreAuthorize("hasRole('P_DELETED')")
    //    @PreAuthorize("hasAuthority('P_DELETED')")

    String ROLE_ADMIN = "hasRole('ROLE_ADMIN')";
    String ROLE_DBA = "hasRole('ROLE_DBA')";
    String ROLE_USER = "hasRole('ROLE_USER')";

    String P_DELETED = "hasAuthority('P_DELETED')";


    /**
     * 命名规则 P_M_O
     * P:权限
     * M:业务上的模块
     * O:操作 包括CRUD
     * [2018-12-14 add by longzhiyou]
     */
    String P_ACCOUNT_D= "hasAuthority('P_ACCOUNT_D')";
}
