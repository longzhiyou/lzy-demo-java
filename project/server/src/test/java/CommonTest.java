import lzy.sys.auth.domain.SoftSerial;
import lzy.sys.security.jwt.JwtTokenUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

/**
 * User: longzhiyou
 * Date: 2017/11/2
 * Time: 18:30
 */
public class CommonTest {

    Logger logger = LoggerFactory.getLogger(CommonTest.class);



    @Test
    public void testRepeat() {
        SoftSerial softSerial = new SoftSerial();
        softSerial.setUuid("hello");
        logger.info(softSerial.getUuid());

    }
    @Test
    public void generatePassword() {


        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(4);
        String encode = passwordEncoder.encode("123456");

        boolean matches = passwordEncoder.matches("123456", encode);
        logger.info("BCryptPasswordEncoder:" + encode);

    }

    @Test
    public void generateToken(){

        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        jwtTokenUtil.setExpiration(3153600000L);

        String tokenByUsername = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiY3JlYXRlZCI6MTU0NDc1Nzk2NTUzNiwiZXhwIjo0Njk4MzU3OTY2fQ.0t2gPLdhmiG36X1OCOZ953uuk7HISgBo9hBmoMFHZOowf71e9JszZxjDdtNF3FMWI8-zaLHQ24qIbjtwHGAsEQ";
        tokenByUsername = jwtTokenUtil.generateTokenByUsername("admin");
        logger.info("tokenByUsername:"+tokenByUsername);
        String username = jwtTokenUtil.getUsernameFromToken(tokenByUsername);
        logger.info("username:"+username);

        Date fromToken = jwtTokenUtil.getExpirationDateFromToken(tokenByUsername);
        logger.info("getExpirationDateFromToken:"+fromToken.toString());


    }

}