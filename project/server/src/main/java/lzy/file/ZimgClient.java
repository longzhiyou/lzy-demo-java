package lzy.file;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 *
 * http://47.105.164.246/zimg/bb0e74d2e02884b07a957bbea9199903?p=0 sh
 * http://47.105.164.246/zimg/b29b933a060702971efe8d03745b8bf5?p=0 pdf
 *
 * 能够支持非图片文件的上传和下载，https://github.com/buaazp/zimg/pull/160
 * zimg.lua中做2处修改：
 *
 * format = 'jpeg' 改为 format = 'none'
 * allowed_type改为 allowed_type = {'image/jpeg', 'image/jpg', 'image/png', 'image/gif', 'image/webp', 'application/zip', 'application/pdf', 'application/msword', 'application/.docx', 'application/octet-stream'}
 * 上传时http头中加 zimg-filename:文件名 ,
 * 例如: zimg-filename:a.pdf
 * 下载非图片文件时需要加p=0参数
 *
 * 返回json 必须是 一张图片的二进制，header 设置为jpeg
 * 访问后缀带p=0访问
 * 试试用 xxx?p=0 这种方式能访问到的话，就是 imagemagick 处理图片失败了。有可能是编译的时候没编好 libpng 相关的库。
 * http://47.105.164.246/zimg/82bfcbcf7cf1cc91a3436e4be7556607?p=0
 * User: longzhiyou
 * Date: 2018/12/18
 * Time: 14:14
 */
public class ZimgClient {
    Logger logger = LoggerFactory.getLogger(ZimgClient.class);

    String url = "http://47.105.164.246/zimg";

    private File getTestFile(){
        return new File("d:\\taxi.jpg");
    }

    public void upload(Map<String, MultipartFile> files){

//
//                HttpHeaders headers = new HttpHeaders();
////        headers.set("Content-Type", "image/jpeg");
//        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
////        headers.setContentType(MediaType.IMAGE_JPEG);
//
//        MultiValueMap<String, Object> body
//                = new LinkedMultiValueMap<>();
//
        for (String key : files.keySet()) {
            MultipartFile file = files.get(key);

            try {
                byte[] imgData =   file.getBytes();
                HttpRequest httpRequest = HttpRequest.post(url+"/upload")
                        .header("Content-Type","jpeg")
                        .body(imgData);

//        //68eac23a59f0a172917478cc7b13b3f2
                HttpResponse httpResponse = httpRequest.execute();
                System.out.println(httpResponse);

            } catch (IOException e) {
                e.printStackTrace();
            }




//            String retJson = HttpTookit.sendPost(uploadUrl, imgData, fileType);
            //json解析有很多框架，所以不做参考了
//            System.out.println(retJson);
        }

//        body.add("files", getTestFile());
//        body.add("files", getTestFile());
//        body.add("files", getTestFile());

//        HttpEntity<MultiValueMap<String, Object>> requestEntity
//                = new HttpEntity<>(body, headers);
//
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> response = restTemplate.postForEntity(url+"/upload", requestEntity, String.class);

//
//        RestTemplate restTemplate = new RestTemplate();
//

//
//        HttpEntity<Map<String, MultipartFile>> requestEntity = new HttpEntity<>(files, headers);
//        ResponseEntity<String> response = restTemplate
//                .postForEntity(url+"/upload", requestEntity, String.class);
//        logger.info(response.toString());
//
//        HttpRequest httpRequest = HttpRequest.post(url+"/upload")
//                .form("file", new File("d:\\demo-ccrc-family-ios.png"));
//
////        //68eac23a59f0a172917478cc7b13b3f2
//        HttpResponse httpResponse = httpRequest.execute();
//        System.out.println(httpResponse);
//        //删除
//        HttpRequest deleteRequest = HttpRequest
//                .get(url+"/admin")
//                .form("md5", "1f9d7eaf87ef15ce09b84659e751ab3e",
//                        "t",1);
//
//        HttpResponse deleteResponse = deleteRequest.execute();
//        System.out.println(deleteResponse);

    }

    private String macthContentType(String fileType){
        String contentType = "image/jpeg";
        switch (fileType) {
            case "bmp":
                contentType = "application/x-bmp";
                break;
            case "img":
                contentType = "application/x-img";
                break;
            case "jpeg":
                contentType = "image/jpeg";
                break;
            case "jpg":
                contentType = "application/x-jpg";
                break;
            case "png":
                contentType = "image/png";
                break;
            default:
                break;
        }
        return contentType;
    }

    public HttpServletResponse uploadFile(HttpServletRequest request){
        MultipartHttpServletRequest mRequest = null;
        MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());

        // 获取request
        try {
            mRequest = resolver.resolveMultipart(request);
            mRequest.setCharacterEncoding("UTF-8");
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        // 获取文件map
        Map<String, MultipartFile> files = mRequest.getFileMap();

        // 检查是否包含文件信息
        if (null == files || files.size() == 0) {
            System.out.println("图片上传异常");
        }

        String uploadUrl="http://192.168.11.11:4869";
        // 保存文件至服务器指定路径
        String fileName = null;
        for (String key : files.keySet()) {
            MultipartFile file = files.get(key);
            fileName = file.getOriginalFilename();

            String fileType = fileName.substring(fileName.lastIndexOf(".")+1, fileName.length());

            byte[] imgData = null;
            try {
                imgData = file.getBytes();
            } catch (IOException e) {
                e.printStackTrace();
            }

//            String retJson = HttpTookit.sendPost(uploadUrl, imgData, fileType);
            //json解析有很多框架，所以不做参考了
//            System.out.println(retJson);
        }
        return null;
    }


}
