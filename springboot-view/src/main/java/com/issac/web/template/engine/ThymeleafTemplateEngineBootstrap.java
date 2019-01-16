package com.issac.web.template.engine;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * author:  ywy
 * date:    2019-01-08
 * desc:
 */
public class ThymeleafTemplateEngineBootstrap {
    public static void main(String[] args) throws IOException {
        // 构建引擎
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        // 创建渲染上下文
        Context context = new Context();
        context.setVariable("message", "HelloWorld");

        // 读取内容  从 classpath:/templates/thymeleaf/hello-world.html
        // ResourceLoader
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        // 通过classpath
        Resource resource = resourceLoader.getResource("classpath:/templates/thymeleaf/hello-world.html");
        File templateFile = resource.getFile();

        // 文件
        FileInputStream inputStream = new FileInputStream(templateFile);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        // Copy
        IOUtils.copy(inputStream,outputStream);


        inputStream.close();


        // 模块内容
//        String content = "<p th:text=\"${message}\">!!!</p>";
        String content = outputStream.toString("UTF-8");
        // 渲染处理结果
        String result = templateEngine.process(content, context);
        // 输出渲染处理结果
        System.out.println(result);
    }
}
