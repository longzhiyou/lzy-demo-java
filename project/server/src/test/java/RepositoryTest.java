import lzy.Application;
import lzy.demo.Book;
import lzy.demo.BookRepository;
import lzy.demo.Publisher;
import lzy.demo.PublisherRepository;
import lzy.sys.auth.entity.Permission;
import lzy.sys.auth.entity.Role;
import lzy.sys.auth.entity.User;
import lzy.sys.auth.repository.UserRepository;
import lzy.sys.auth.repository.UserRepositoryMybatis;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void user(){
        User one = userRepository.findOne(2L);

        Set<Role> roles = one.getRoles();

       for (Role role: roles){
           Set<Permission> permissions = role.getPermissions();


       }


        logger.info(one.toString());
    }


    @Test
    @Transactional
//    @Rollback(false)
    public void book(){
        // save a couple of books®
        final Publisher publisherA = new Publisher("Publisher A");
        final Publisher publisherB = new Publisher("Publisher B");
        final Publisher publisherC = new Publisher("Publisher C");

        bookRepository.save(new HashSet<Book>(){{
            add(new Book("Book A", new HashSet<Publisher>(){{
                add(publisherA);
                add(publisherB);
            }}));

            add(new Book("Book B", new HashSet<Publisher>(){{
                add(publisherA);
                add(publisherC);
            }}));
        }});

        // fetch all books
        for(Book book : bookRepository.findAll()) {
            logger.info(book.toString());
        }

        // save a couple of publishers
        final Book bookA = new Book("Book A");
        final Book bookB = new Book("Book B");

        publisherRepository.save(new HashSet<Publisher>() {{
            add(new Publisher("Publisher A", new HashSet<Book>() {{
                add(bookA);
                add(bookB);
            }}));

            add(new Publisher("Publisher B", new HashSet<Book>() {{
                add(bookA);
                add(bookB);
            }}));
        }});

        // fetch all publishers
        for(Publisher publisher : publisherRepository.findAll()) {
            logger.info(publisher.toString());
        }
    }

    @Test
    @Transactional
//    @Rollback(false)
    public void filterDevice(){

//        userRepository.findFirstByUsername("admin");
//        List<String> permissions = userRepositoryMybatis.findPermissions((long) 2);

//        logger.info(permissions.toString());

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