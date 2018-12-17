package pjx.test.amqp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;
import org.springframework.context.annotation.Configuration;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 18/12/16
 */
@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableTurbineStream
public class AppBoot {
    public static void main(String[] args) {
        SpringApplication.run(AppBoot.class, args);
    }
}
