package com.issac.spring.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * author:  ywy
 * date:    2019-01-13
 * desc: 异步 Servlet
 */
@WebServlet(
        asyncSupported = true, // 激活异步特性
        name = "syncServlet", // Servlet 名字
        urlPatterns = "/async-servlet"
)
public class AsyncServlet extends HttpServlet {

    // 覆盖 service
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 判断是否支持异步
        if (req.isAsyncSupported()) {
            // 创建 AsyncContext
            AsyncContext asyncContext = req.startAsync();
            asyncContext.setTimeout(50L);
            // 创建监听器
            asyncContext.addListener(new AsyncListener() {
                @Override
                public void onComplete(AsyncEvent event) throws IOException {
                    println("执行完成");
                }

                @Override
                public void onTimeout(AsyncEvent event) throws IOException {
                    HttpServletResponse servletResponse = (HttpServletResponse) event.getSuppliedResponse();
                    servletResponse.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
                    println("执行超时");

                }

                @Override
                public void onError(AsyncEvent event) throws IOException {
                    println("执行异常");
                }

                @Override
                public void onStartAsync(AsyncEvent event) throws IOException {
                    println("执行开始");

                }
            });

            println("Hello World 2019");

            ServletResponse servletResponse = asyncContext.getResponse();
            // 获取字符输出流
            // 设置响应媒体类型
//            servletResponse.setContentType("text/plain;charset=UTF-8");
//            PrintWriter writer = servletResponse.getWriter();
//            writer.println("Hello World");
//            writer.flush();

        }
    }

    private static void println(Object object) {
        String threadName = Thread.currentThread().getName();
        System.out.println("AsyncServlet[" + threadName + "] ： " + object);
    }
}
