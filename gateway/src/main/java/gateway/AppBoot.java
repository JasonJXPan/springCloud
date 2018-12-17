package gateway;

import gateway.filter.AccessFilter;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 18/12/16
 */
@SpringCloudApplication
@EnableZuulProxy
public class AppBoot {
    //http://localhost:1101/pjx-eureka-client2/comsumer?accessToken=12
    public static void main(String[] args) {
        new SpringApplicationBuilder(AppBoot.class).web(true).run(args);
    }
    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }
}
