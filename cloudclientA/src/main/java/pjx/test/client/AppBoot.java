package pjx.test.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 18/12/15
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AppBoot {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(AppBoot.class).web(true).run(args);
    }
}
