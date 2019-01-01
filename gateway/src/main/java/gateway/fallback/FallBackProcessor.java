package gateway.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * 类作用描述
 * 可以通过实现ZuulFallbackProvider 或者高版本实现FallbackProvider
 *
 * @author panjinxin
 * @since 18/12/23
 */
@Component
public class FallBackProcessor implements ZuulFallbackProvider {
    @Override
    public String getRoute() {
        System.out.println("fallbackroute");
        return null;
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        System.out.println("fallback");
        return null;
    }
}
