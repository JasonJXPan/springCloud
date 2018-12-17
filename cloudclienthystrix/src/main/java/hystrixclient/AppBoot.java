package hystrixclient;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 18/12/15
 */
//或者是@EnableCircuitBreaker， 注解开启Hystrix的使用
@EnableHystrix
//注解开启扫描Spring Cloud Feign客户端的功能
@EnableFeignClients
//该注解能激活Eureka中的DiscoveryClient实现，这样才能实现Controller中对服务信息的输出
@EnableDiscoveryClient
@SpringBootApplication
public class AppBoot {

    @Bean(name = "restTemplate")
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean(name = "loadBalanceRestTemplate")
    @Qualifier("loadBalanceRestTemplate")
    @LoadBalanced
    public RestTemplate loadBalanceRestTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(AppBoot.class).web(true).run(args);
    }
}
