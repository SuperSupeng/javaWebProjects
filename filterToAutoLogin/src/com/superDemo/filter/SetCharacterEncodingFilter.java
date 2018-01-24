package com.superDemo.filter;

import javax.servlet.*;
import java.io.IOException;

public class SetCharacterEncodingFilter implements Filter {
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String encoding = filterConfig.getInitParameter("encoding");//用户可能忘记了配置该参数
        if(encoding==null){
            encoding = "UTF-8";//默认编码
        }

        request.setCharacterEncoding(encoding);//只能解决POST请求参数的中文问题
        response.setCharacterEncoding(encoding);//输出流编码
        response.setContentType("text/html;charset="+encoding);//输出流编码，通知了客户端应该使用的编码
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
