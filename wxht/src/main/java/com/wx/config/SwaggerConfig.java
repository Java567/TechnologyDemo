package com.wx.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2 // 允许使用swagger-ui
@ConditionalOnExpression("${swagger.enable:true}") // 只有当swagger.enable值为true时才加载
public class SwaggerConfig {

    @Bean
    public Docket docket () {

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder().title("微信小程序demo平台API接口文档")
                        .contact(new Contact("华东交大", "#", "tony@pxcoder.com"))
                        .description("这是微信小程序demo平台API文档的描述信息").version("1.0")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wx.controller")) // 扫描构建API接口的package
                .paths(PathSelectors.any()).build();
        return docket;
    }
}
