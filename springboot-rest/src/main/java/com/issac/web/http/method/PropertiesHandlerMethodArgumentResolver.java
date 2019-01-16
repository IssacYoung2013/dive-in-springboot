package com.issac.web.http.method;

import com.issac.web.http.converter.properties.PropertiesHttpMessageConverter;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * @author:  ywy
 * @date:    2019-01-11
 * @desc:
 */
public class PropertiesHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return Properties.class.equals(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        ServletWebRequest servletWebRequest = (ServletWebRequest)webRequest;

        // 复用
        PropertiesHttpMessageConverter converter = new PropertiesHttpMessageConverter();

        // Servlet Request API
        HttpServletRequest request = servletWebRequest.getRequest();
        HttpInputMessage inputMessage = new ServletServerHttpRequest(request);

        return converter.read(null,null,inputMessage);

//        String contentType = request.getHeader("Content-Type");
//        MediaType mediaType =  MediaType.parseMediaType(contentType);
//
//        // 获取字符编码
//        Charset charset = mediaType.getCharset();
//
//        // 当不存在时 使用 UTF-8
//        charset = charset == null ? Charset.forName("UTF-8") : charset;
//
//        // 请求输入字节流
//        InputStream inputStream = request.getInputStream();
//        InputStreamReader reader = new InputStreamReader(inputStream, charset);
//
//        Properties properties = new Properties();
//        properties.load(reader);
//        return properties;
    }
}
