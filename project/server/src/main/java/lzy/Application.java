package lzy;

import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableAsync
@EnableJpaAuditing
@EnableCaching
@EnableScheduling
public class Application implements CommandLineRunner {
    private static Logger logger = Logger.getLogger(Application.class);


    @Bean
    public RestTemplate restTemplate(){
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(1000);
        requestFactory.setReadTimeout(1000);

        RestTemplate restTemplate = new RestTemplate(requestFactory);
        return restTemplate;
    }


    public static void main(String[] args) {

        ApplicationContext ctx =  SpringApplication.run(Application.class, args);
//        HikVision hikVision =  (HikVision)ctx.getBean("hikVision");
//        hikVision.connectMq();

    }

    @Override
    public void run(String... args) throws Exception {

        logger.debug("run Do something...");

        //让主线程阻塞让程序不退出,没有web框架时使用
//        Thread.currentThread().join();

    }
}
