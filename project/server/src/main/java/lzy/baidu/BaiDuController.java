package lzy.baidu;

import lzy.common.CommonDefine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        baiDuService.ocr();
        return new ResponseEntity(HttpStatus.OK);

    }
}
