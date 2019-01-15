package lzy.sys.web;

import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

import javax.servlet.Filter;

/**
 * User: longzhiyou
 * Date: 2019/1/15
 * Time: 10:53
 */

@Configuration
public class WebApplicationConfiguration  extends WebMvcAutoConfiguration {

    @Bean
    public Filter etagFilter() {
        return new ShallowEtagHeaderFilter();
    }
}
