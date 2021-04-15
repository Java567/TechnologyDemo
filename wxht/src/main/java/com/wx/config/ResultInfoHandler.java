package com.wx.config;

import com.wx.core.ResultInfo;
import com.wx.core.util.ResultInfoUtil;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import springfox.documentation.swagger.web.ApiResourceController;
import springfox.documentation.swagger2.web.Swagger2Controller;

@ControllerAdvice // 定义一个Controller的切面
public class ResultInfoHandler implements ResponseBodyAdvice { // ResponseBodyAdvice拦截Controller方法返回结果时进行处理

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) { // 拦截方法
        Class clazz = returnType.getContainingClass();
        if (clazz ==  ApiResourceController.class || clazz == Swagger2Controller.class) {
            return false;
        }
        // 判断方法或者类是否包含有@ResponseBody注解
        boolean isResponseBody = (AnnotatedElementUtils.hasAnnotation(returnType.getContainingClass(),
                ResponseBody.class) ||
                returnType.hasMethodAnnotation(ResponseBody.class));
        return isResponseBody;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType,
                                  MediaType selectedContentType, Class selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {

        // 判断Controller方法返回的是否是ResultInfo对象，如果是就直接返回
        if (body instanceof ResultInfo) {
            return body;
        }
        // 如果不是，那么构建一个ResultInfo对象
        ResultInfo<Object> resultInfo = ResultInfoUtil.buildSuccess(body);

        return resultInfo;
    }
}
