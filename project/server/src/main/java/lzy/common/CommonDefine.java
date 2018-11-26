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


    /**
     * 应用类别
     */
    String CLIENT_APP_TYPE_BUSINESS = "1"; //业务APP
    String CLIENT_APP_TYPE_BACKGROUND = "0"; //后台管理APP

    /**
     *  床垫厂家类型
     *  为了以后的扩展,后面的作为设备厂家类型提供
     * [2017-10-13 add by longzhiyou]
     */
    String MATTRESS_MANUFACTURE_SOMNIC =  "somnic"; //杭州舒眠科技厂家
    String MATTRESS_MANUFACTURE_DARMA =  "darma"; //深圳市大耳马科技有限公司
    String MATTRESS_MANUFACTURE_HTJR =  "htjr"; //烟台汇通佳仁科技有限公司

    String MANUFACTURE_CAT_CALL =  "catcall"; //多嘴猫呼叫




}
