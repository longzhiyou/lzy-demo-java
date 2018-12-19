package lzy.demo;

import lzy.common.CommonDefine;
import lzy.sys.auth.domain.SoftSerial;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static lzy.common.domain.GrantedAuthorityDefine.ROLE_ADMIN;

/**
 * User: longzhiyou
 * Date: 2018/11/26
 * Time: 14:51
 */

@RestController
@RequestMapping(value = CommonDefine.BASE_URI+"/admin")
//@PreAuthorize("hasRole('ADMIN')")
@PreAuthorize(ROLE_ADMIN)
public class AdminController {
    Logger logger = LoggerFactory.getLogger(AdminController.class);

    @GetMapping(value = "/uuid")
    public ResponseEntity ocr() {

        SoftSerial softSerial = new SoftSerial();
        softSerial.setUuid("hello");
        logger.info(softSerial.getUuid());
        return new ResponseEntity(softSerial,HttpStatus.OK);

    }

}
