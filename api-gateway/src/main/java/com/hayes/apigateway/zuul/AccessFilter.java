package com.hayes.apigateway.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class AccessFilter extends ZuulFilter {

    private static Logger logger= LoggerFactory.getLogger(AccessFilter.class);

    @Override
    public String filterType() {

        //过滤器的类型， 它决定过滤器在请求的哪个生命周期中执行。 这里 定义为pre, 代表会在请求被路由之前执行。
        // pre: 可以在请求被路由之前调用。
        // routing: 在路由请求时被调用。
        // post: 在 routing 和 error 过滤器之后被调用。
        // error: 处理请求时发生错误时被调用。

        return "pre";
    }

    @Override
    public int filterOrder() {
        //过滤器的执行顺序。 当请求在 个阶段中存在多个过滤器时， 需 要根据该方法返回的值来依次执行。
        //数值越小优先级越高。

        return 0;
    }

    @Override
    public boolean shouldFilter() {

        //判断该过滤器是否需要被执行。 这里我们直接返回了true, 因 此该过滤器对所有请求都会生效。
        // 实际运用中我们可以利用该函数来指定过滤器的 有效范围。

        return true;
    }

    @Override
    public Object run() {
        //过滤器的具体逻辑。

        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

        logger.info("send {} request to {}" , request.getMethod(), request.getRequestURL().toString());

        String token = request.getParameter("accessToken");
        if (token==null){
            logger.warn("access token is empty !!! ");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            return null;
        }

        logger.info("access token OK ");

        return null;
    }
}
