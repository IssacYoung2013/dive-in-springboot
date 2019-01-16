package com.issac.web.http.method;

import com.issac.web.http.converter.properties.PropertiesHttpMessageConverter;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 *
 * author:  ywy
 * date:    2019-01-11
 * desc:
 */
public class PropertiesHandlerMethodReturnValueHandler implements HandlerMethodReturnValueHandler {

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {

        // 判断方法类型与返回值是否匹配
        return Properties.class.equals( returnType.getMethod().getReturnType());
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {

        // 强制转换
        Properties properties = (Properties) returnValue;

        // 复用
        PropertiesHttpMessageConverter converter = new PropertiesHttpMessageConverter();

        // Servlet Request API
        ServletWebRequest servletWebRequest =  (ServletWebRequest)webRequest;
        HttpServletRequest request = servletWebRequest.getRequest();

        String contentType = request.getHeader("Content-Type");
        MediaType mediaType =  MediaType.parseMediaType(contentType);

        // 获取字符编码
        Charset charset = mediaType.getCharset();

        // 当不存在时 使用 UTF-8
        charset = charset == null ? Charset.forName("UTF-8") : charset;

        HttpServletResponse response = servletWebRequest.getResponse();
        HttpOutputMessage message = new ServletServerHttpResponse(response);

        converter.write(properties,mediaType,message);

        // 通知输出
        mavContainer.setRequestHandled(true);
    }
}
