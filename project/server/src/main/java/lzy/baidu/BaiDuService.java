package lzy.baidu;


import com.baidu.aip.ocr.AipOcr;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
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
            Stream<Path> pathStream = Files.walk(this.rootLocation, 1)
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(path -> this.rootLocation.relativize(path));

//            Files.walk(Paths.get(SOURCEDIR)).filter(Files::isRegularFile).forEach(filePath ->{
//
//                String name=filePath.getFilename().toString();
//
//                if (name.startWith("_O"){
//                    System.out.println(filePath.getFileName());
//                }
//
//            });



            pathStream.forEach(
                    filePath -> {
                        if (true){

                            System.out.println(filePath.getFileName());
                            FileInfo fileInfo = new FileInfo();
                            fileInfo.setFileName(filePath.getFileName().toString());
                            fileInfos.add(fileInfo);
                        }
                    }
            );
//            pathStream.map(
//                    path -> MvcUriComponentsBuilder.fromMethodName(serveFile", path.getFileName().toString()).build().toString())
//                    .collect(Collectors.toList()));



        } catch (IOException e) {

        }

        return fileInfos;

    }

    public void ocr(String image){


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

        JSONObject res = client.taxiReceipt(image, options);
        System.out.println(res.toString(2));




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
