package pjx.test.consul.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 18/12/15
 */
//使用@FeignClient注解来指定这个接口所要调用的服务名称
//    由于Feign是基于Ribbon实现的，所以它自带了客户端负载均衡功能，也可以通过Ribbon的IRule进行策略扩展。另外，Feign还整合的Hystrix来实现服务的容错保护
@FeignClient("pjx-eureka-client")
public interface DcClient {

    @GetMapping("/comsumer_ribbon")
    String comsumerRibbon();
}
