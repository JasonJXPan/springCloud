package pjx.test.client.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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
    @Qualifier("restTemplate")
    private RestTemplate restTemplate;
    @Autowired
    @Qualifier("loadBalanceRestTemplate")
    private RestTemplate loadBalanceRestTemplate;

    @GetMapping("/dc")
    public String dc() {
//        线程暂停，会使hystrix因为请求超时而降级
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<String> services = discoveryClient.getServices();
        return StringUtils.join(services, ",") +"from eurekaClient";
    }

    @GetMapping("/dc1")
    public String dc1() {
        List<String> services = discoveryClient.getServices();
        return StringUtils.join(services, ",") +"from eurekaClient";
    }
    @GetMapping("/comsumer")
    public String comsumer() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("pjx-eureka-client");
        String url = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/dc1";
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }
    @GetMapping("/comsumer_ribbon")
    public String comsumerRibbon() {
        return "ribbon" + loadBalanceRestTemplate.getForObject("http://pjx-flex-to-eureka-consul-client/dc", String.class);
    }
}
