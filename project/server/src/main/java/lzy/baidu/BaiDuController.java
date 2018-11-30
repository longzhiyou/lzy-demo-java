package lzy.baidu;

import lzy.common.CommonDefine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * User: longzhiyou
 * Date: 2018/11/26
 * Time: 14:51
 */

@RestController
@RequestMapping(value = CommonDefine.BASE_URI+"/baidu")
public class BaiDuController {

    @Autowired
    BaiDuService baiDuService;

    @GetMapping(value = "/ocr")
    public ResponseEntity ocr() {
        String image = "d:\\taxi.jpg";
        List<FileInfo> fileInfos = baiDuService.taxiOcr();
        return new ResponseEntity(fileInfos,HttpStatus.OK);

    }

    @GetMapping(value = "/files")
    public ResponseEntity files() {
        List<FileInfo> fileInfos = baiDuService.loadAll();
        return new ResponseEntity(fileInfos,HttpStatus.OK);

    }
}
