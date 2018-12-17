package pjx.test.consul;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 18/12/15
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class AppBoot {
    public static void main(String[] args) {
        new SpringApplicationBuilder(AppBoot.class).web(true).run(args);
    }
}
