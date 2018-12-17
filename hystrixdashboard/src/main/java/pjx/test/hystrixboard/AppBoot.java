package pjx.test.hystrixboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 18/12/16
 */
@EnableHystrixDashboard
@SpringBootApplication
public class AppBoot {
    public static void main(String[] args) {
        //http://localhost:1301/hystrix
        //单例 输入http://localhost:2003/hystrix.stream
        //turbine http://localhost:8989/turbine.stream
        SpringApplication.run(AppBoot.class, args);
    }
}
