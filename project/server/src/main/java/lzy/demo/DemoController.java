package lzy.demo;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import lzy.common.CommonDefine;
import lzy.file.ZimgClient;
import lzy.sys.auth.domain.SoftSerial;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Map;

/**
 * User: longzhiyou
 * Date: 2018/11/26
 * Time: 14:51
 */

@RestController
@RequestMapping(value = CommonDefine.BASE_URI+"/demo")
public class DemoController {
    Logger logger = LoggerFactory.getLogger(DemoController.class);

    @GetMapping(value = "/uuid")
    public ResponseEntity ocr() {

        SoftSerial softSerial = new SoftSerial();
        softSerial.setUuid("hello");
        logger.info(softSerial.getUuid());
        return new ResponseEntity(softSerial,HttpStatus.OK);

    }

    //MediaType.ALL_VALUE, produces =  { "application/pdf"},"application/xml", "text/xml"
    @GetMapping(value = "/download")
    public ResponseEntity download() {


        //pdf
        HttpRequest httpRequest = HttpRequest.get("http://47.105.164.246/zimg/b29b933a060702971efe8d03745b8bf5?p=0");
        //sh
//        HttpRequest httpRequest = HttpRequest.get("http://47.105.164.246/zimg/bb0e74d2e02884b07a957bbea9199903?p=0");

//        //68eac23a59f0a172917478cc7b13b3f2
        HttpResponse httpResponse = httpRequest.execute();

//        return ResponseEntity.ok()
//                .contentLength(gridFsFile.getLength())
//                .contentType(MediaType.parseMediaType(gridFsFile.getContentType()))
//                .body(new InputStreamResource(gridFsFile.getInputStream()));
        //根据数据库存储的类型 进行匹配
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_PDF)
//                .contentType()
                .body(httpResponse.bodyBytes());

//        return httpResponse.bodyBytes();

    }


    @RequestMapping(value = "/upload",method= RequestMethod.POST)
    public ResponseEntity handleHealthDataList(MultipartHttpServletRequest mRequest)  {


        Map<String, String[]> parameterMap = mRequest.getParameterMap();

        // 获取文件map
        Map<String, MultipartFile> files = mRequest.getFileMap();

        // 检查是否包含文件信息
        if (null == files || files.size() == 0) {
            System.out.println("图片上传异常");
        }

        ZimgClient zimgClient = new ZimgClient();
        zimgClient.upload(files);
        return new ResponseEntity(HttpStatus.OK);
    }

}
