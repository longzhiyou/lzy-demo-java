package lzy.common;

/**
 * User: longzhiyou
 * Date: 2017/10/11
 * Time: 19:23
 */
public interface CommonDefine {

    String BASE_URI = "/api";
    String NOT_DELETED = "deleted_on IS NULL  OR deleted_on > CURRENT_TIMESTAMP";
    String DELETED_FIELD = "deletedOn";
    int PASSWORD_ENCODER_STRENGTH=4;


}
