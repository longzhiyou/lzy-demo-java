package lzy.module.account.controller;

import lzy.common.CommonDefine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static lzy.common.domain.GrantedAuthorityDefine.P_DELETED;

/**
 * User: longzhiyou
 * Date: 2018/11/26
 * Time: 14:51
 */

@RestController
@RequestMapping(value = CommonDefine.BASE_URI+"/accounts")
public class AccountController {
    Logger logger = LoggerFactory.getLogger(AccountController.class);

    @GetMapping()
    @PreAuthorize(value =P_DELETED)
    public ResponseEntity index() {

        return new ResponseEntity(HttpStatus.OK);

    }

}
