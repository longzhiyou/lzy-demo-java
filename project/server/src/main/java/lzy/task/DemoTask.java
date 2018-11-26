package lzy.task;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * User: longzhiyou
 * Date: 2018/11/5
 * Time: 11:07
 */
@Component
public class DemoTask {

    private static Logger logger = Logger.getLogger(DemoTask.class);


//    @Scheduled(cron="0/10 * *  * * ? ")   //每10秒执行一次
    public void locationTask(){
        logger.info("定时任务,每10秒执行一次 ");

    }


}
