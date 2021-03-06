package lzy.baidu;


import com.baidu.aip.ocr.AipOcr;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

/**
 * 百度相关的服务
 * @link(http://ai.baidu.com/docs#/TTS-API/top)
 * User: longzhiyou
 * Date: 2018/3/28
 * Time: 9:57
 */
@Component
public class BaiDuService {

    private final Logger logger = Logger.getLogger(BaiDuService.class);

    Path rootLocation = Paths.get("upload-dir");

    public List<FileInfo> loadAll() {

        List<FileInfo> fileInfos = new ArrayList<>();

        try {


            Files.walk(this.rootLocation, 1).filter(Files::isRegularFile).forEach(filePath ->{

                System.out.println(filePath.getFileName());
                FileInfo fileInfo = new FileInfo();
                fileInfo.setFileName(filePath.getFileName().toString());
                fileInfo.setAbsolutePath(
                        rootLocation.toAbsolutePath().toString()
                                +System.getProperty("file.separator")
                                +filePath.getFileName());
                fileInfos.add(fileInfo);

            });


//            Stream<Path> pathStream = Files.walk(this.rootLocation, 1)
//                    .filter(path -> !path.equals(this.rootLocation))
//                    .map(path -> this.rootLocation.relativize(path));
//
//
//
//            pathStream.forEach(
//                    filePath -> {
//                        if (true){
//
//                            System.out.println(filePath.getFileName());
//                            FileInfo fileInfo = new FileInfo();
//                            fileInfo.setFileName(filePath.getFileName().toString());
//                            fileInfo.setAbsolutePath(
//                                    rootLocation.toAbsolutePath().toString()
//                                            +System.getProperty("file.separator")
//                                            +filePath.getFileName());
//                            fileInfos.add(fileInfo);
//                        }
//                    }
//            );
//            pathStream.map(
//                    path -> MvcUriComponentsBuilder.fromMethodName(serveFile", path.getFileName().toString()).build().toString())
//                    .collect(Collectors.toList()));



        } catch (IOException e) {

        }

        return fileInfos;

    }

    /**
     *
     * @return
     */
    public List<FileInfo> repeatFlag(List<FileInfo> infos) {


        for (int i = 0; i < infos.size(); i++) {
            FileInfo iIinfo = infos.get(i);
            iIinfo.setNo(i+1);
            for (int j = i+1; j < infos.size(); j++) {
                FileInfo jIinfo = infos.get(j);

                if (!StringUtils.isEmpty(iIinfo.getTaxiNum())&&!StringUtils.isEmpty(jIinfo.getTaxiNum())) {
                    if (iIinfo.getTaxiNum().equals(jIinfo.getTaxiNum())) {

                        iIinfo.setTaxiNumRepeatText("车牌号重复");
                        iIinfo.setTaxiNumRepeat(true);

                        jIinfo.setTaxiNumRepeatText("车牌号重复");
                        jIinfo.setTaxiNumRepeat(true);
                    }
                }

                if (!StringUtils.isEmpty(iIinfo.getDate())&&!StringUtils.isEmpty(jIinfo.getDate())) {
                    if (iIinfo.getDate().equals(jIinfo.getDate())) {

                        iIinfo.setDateRepeatText("日期重复");
                        iIinfo.setDateRepeat(true);

                        jIinfo.setDateRepeatText("日期重复");
                        jIinfo.setDateRepeat(true);
                    }
                }
            }
        }

        return infos;
    }

    public List<FileInfo> taxiOcr(){


        //临时设置APPID/AK/SK,以后从数据库获取
         String APP_ID = "14943176";
         String API_KEY = "dHd1jIzYtucO9C6PiZSSz4fn";
        String SECRET_KEY = "Xtpjcvrk4AvfLkzQ5GWRjkVQBajG3Umu";

        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);


        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(5000);
        client.setSocketTimeoutInMillis(60000);

        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();

        // 调用接口
        // 参数为本地路径

        List<FileInfo> fileInfos = loadAll();
        for (FileInfo fileInfo : fileInfos) {
            logger.info("【当前要识别】"+fileInfo.getFileName());
//            JSONObject res = client.taxiReceipt(fileInfo.getAbsolutePath(), options);
//            System.out.println(res.toString(2));
//
//            JSONObject words_result = null;
//            try {
//                words_result = res.getJSONObject("words_result");
//            }catch (Exception e){
//
//            }
//
//            if (words_result!=null) {
//
//                fileInfo.setDate(words_result.getString("Date"));
//                fileInfo.setFare(words_result.getString("Fare"));
//                fileInfo.setInvoiceCode(words_result.getString("InvoiceCode"));
//                fileInfo.setInvoiceNum(words_result.getString("InvoiceNum"));
//                fileInfo.setTaxiNum(words_result.getString("TaxiNum"));
//                fileInfo.setTime(words_result.getString("Time"));
//            }


        }

        return fileInfos;






    }

    /**
     * 文本合成语音
     * @return 失败返回null 成功返回对应的mp3字节流数据
     */
//    public  TtsResponse text2Audio(String text) {
//        // 调用接口
//        if (clientAipSpeech==null) {
//            updateclientAipSpeech();
//        }
//        return clientAipSpeech.synthesis(text, "zh", 1, null);
//
//
//    }

}
