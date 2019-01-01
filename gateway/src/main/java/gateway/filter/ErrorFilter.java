package gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.util.ConcurrentModificationException;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 18/12/23
 */
@Component
public class ErrorFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        Throwable throwable = currentContext.getThrowable();
        currentContext.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        currentContext.set("error.exception", throwable.getCause());

        return null;
    }
}
