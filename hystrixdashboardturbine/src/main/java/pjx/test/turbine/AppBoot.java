package pjx.test.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.Configuration;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 18/12/16
 */
@EnableDiscoveryClient
@Configuration
@EnableAutoConfiguration
@EnableTurbine
public class AppBoot {
    public static void main(String[] args) {
        SpringApplication.run(AppBoot.class, args);
    }
}

