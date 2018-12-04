package lzy.baidu;

import lombok.Data;

/**
 * User: longzhiyou
 * Date: 2018/11/28
 * Time: 15:34
 */
@Data
public class FileInfo {

    //编号从1开始
    Integer no;
    String fileName;
    String absolutePath;

    String date;//	日期
    boolean dateRepeat=false;//	日期重复
    String dateRepeatText="";

    String fare;//	实付金额
    String invoiceCode	;//	发票代号
    String invoiceNum	;//	发票号码
    String taxiNum	;//	车牌号
    boolean taxiNumRepeat=false;//	车牌号重复
    String taxiNumRepeatText="";//	车牌号重复

    String time	;//	上下车时间
    String parseResult;//解析结果

}
