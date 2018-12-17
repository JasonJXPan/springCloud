package pjx.test.consul.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pjx.test.consul.clients.DcClient;

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
    private DcClient eurekaClient;

    @GetMapping("/dc")
    public String dc() {
        List<String> services = discoveryClient.getServices();
        return StringUtils.join(services, ",") + "from fakeConsulClient";
    }

    @GetMapping("/eureka_comsumer_ribbon")
    public String eurekaConsumeRibbon() {
        return eurekaClient.comsumerRibbon();
    }
}
