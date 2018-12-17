package pjx.test.client.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    private RestTemplate restTemplate;

    @GetMapping("/dc")
    public String dc() {
        List<String> services = discoveryClient.getServices();
        return StringUtils.join(services, ",");
    }
    @GetMapping("/comsumer")
    public String comsumer() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("pjx_flex_to_eureka_consul_client");
        String url = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/dc";
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }
}
