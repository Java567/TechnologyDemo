package com.wx.core.wechatutil;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author me
 * Created by me on 2018-07-09 01:00
 */
@Component
@PropertySource("classpath:config.properties")
@Data
public class ProjectConfig {

    private static ProjectConfig properties;
    @Value("${project.login.url}")
    private String loginUrl;
    @Value("${project.app.id}")
    private String appId;
    @Value("${project.app.secret}")
    private String appSecret;
    @Value("${project.weixin.openid.api}")
    private String weiXinApi;
    @Value("${project.weixin.token.api}")
    private String weiXinTokenApi;
    @Value(" ${project.weixin.message.api}")
    private String weiXinMessageApi;
    @Value("${project.session.name}")
    private String sessionUserInfoKey;
    @Value("${project.date.format}")
    private String dateFormat;
}
