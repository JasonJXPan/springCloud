package pjx.test.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 18/12/15
 */
@EnableEurekaServer
@SpringBootApplication
public class AppBoot {

    public static void main(String[] args) {
        new SpringApplicationBuilder(AppBoot.class).web(true).run(args);
    }
}
