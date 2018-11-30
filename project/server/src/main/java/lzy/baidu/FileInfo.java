package lzy.baidu;

import lombok.Data;

/**
 * User: longzhiyou
 * Date: 2018/11/28
 * Time: 15:34
 */
@Data
public class FileInfo {

    String fileName;
    String absolutePath;

    String date;//	日期
    String fare;//	实付金额
    String invoiceCode	;//	发票代号
    String invoiceNum	;//	发票号码
    String taxiNum	;//	车牌号
    String time	;//	上下车时间
    String parseResult;//解析结果

}
