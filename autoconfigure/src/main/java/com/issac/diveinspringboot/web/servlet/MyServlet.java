package com.issac.diveinspringboot.web.servlet;

import org.springframework.boot.web.servlet.ServletComponentScan;

//import javax.servlet.AsyncContext;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * author:  ywy
 * date:    2019-01-05
 * desc:
 */
//@WebServlet(urlPatterns = "/my/servlet",asyncSupported = true)
//public class MyServlet extends HttpServlet{
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        AsyncContext asyncContext = req.startAsync();
//
//        asyncContext.start(() -> {
//            try {
//                resp.getWriter().println("Hello，World");
//                // 触发完成
//                asyncContext.complete();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        });
//
//    }
//}
