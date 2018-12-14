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

    String P_DELETED = "hasAuthority('P_DELETED')";
}
