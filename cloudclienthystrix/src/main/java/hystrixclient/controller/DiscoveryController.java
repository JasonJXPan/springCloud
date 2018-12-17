package hystrixclient.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 18/12/15
 */
@RestController
public class DiscoveryController {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    ConsumeService consumerService;

    @GetMapping("/consumer")
    public String dc() {
        return consumerService.consumer();
    }

    @GetMapping("/consumer1")
    public String dc1() {
        return consumerService.consumer1();
    }


    @Service
    class ConsumeService {
        @Autowired
        @Qualifier("restTemplate")
        private RestTemplate restTemplate;
        @Autowired
        @Qualifier("loadBalanceRestTemplate")
        private RestTemplate loadBalanceRestTemplate;

        //fallbackMethod 的值为fallback之后的方法名 必须保证方法名存在，并且当前方法的参数和fallback的方法参数以及返回值完全一致
        @HystrixCommand(fallbackMethod = "fallBack")
        public String consumer() {
            return loadBalanceRestTemplate.getForObject("http://pjx-eureka-client/dc", String.class);
        }
        public String fallBack() {
            return "fallback";
        }

        public String consumer1() {
            return loadBalanceRestTemplate.getForObject("http://pjx-eureka-client/dc1", String.class);
        }
    }
}
