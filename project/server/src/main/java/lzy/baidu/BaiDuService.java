package lzy.baidu;


import com.baidu.aip.ocr.AipOcr;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.HashMap;

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



    public void ocr(){

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
        String image = "d:\\taxi.jpg";
        JSONObject res = client.taxiReceipt(image, options);
        System.out.println(res.toString(2));

//        // 参数为二进制数组
//        byte[] file = readFile("test.jpg");
//        res = client.taxiReceipt(file, options);
//        System.out.println(res.toString(2));

//        String path = "d:\\taxi.jpg";
//        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
//        System.out.println(res.toString(2));




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
