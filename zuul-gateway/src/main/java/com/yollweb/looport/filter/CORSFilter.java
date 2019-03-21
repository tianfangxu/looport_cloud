package com.yollweb.looport.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class CORSFilter extends ZuulFilter {

    /*
    PRE: 这种过滤器在请求被路由之前调用。可利用其实现身份验证等
    ROUTING: 这种过滤器将请求路由到微服务，用于构建发送给微服务的请求，并使用Apache Http Client或者Netflix Ribbon请求微服务
    POST: 这种过滤器在路由到微服务以后执行，比如为响应添加标准的HTTP Header，收集统计信息和指标，将响应从微服务发送到客户端等
    ERROR: 在其他阶段发生错误时执行该过滤器
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;           // 顺序设置为1,数据越大，优先级越高
    }

    @Override
    public boolean shouldFilter() {
        return true;        //true:过滤器才会生效
    }

    @Override
    public Object run() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        System.out.println("------------"+request.getRequestURI());
        return null;
    }
}
