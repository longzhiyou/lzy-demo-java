import lzy.Application;
import lzy.sys.auth.repository.UserRepository;
import lzy.sys.auth.repository.UserRepositoryMybatis;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: longzhiyou
 * Date: 2017/10/23
 * Time: 19:03
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.NONE, classes = Application.class)
public class RepositoryTest {

    Logger logger = LoggerFactory.getLogger(RepositoryTest.class);

    @Autowired
    UserRepository userRepository;


    @Autowired
    private UserRepositoryMybatis userRepositoryMybatis;


    @Test
    @Transactional
//    @Rollback(false)
    public void filterDevice(){

//        userRepository.findFirstByUsername("admin");
        List<String> permissions = userRepositoryMybatis.findPermissions((long) 2);

        logger.info(permissions.toString());

//        ClientApp clientApp = new ClientApp();
//
//        clientApp.setAppId("2");
//        clientApp.setAppName("test");
//        clientAppRepository.save(clientApp);
////
//        ClientApp one = clientAppRepository.getOne(1);
//        List<ClientApp> all = clientAppRepository.findAll();
//
//
//        assertNotNull(one);

    }

}