//package com.wx.service;
//
//import com.alibaba.fastjson.JSON;
//import com.mage.core.wechatutil.ProjectConfig;
//import com.mage.core.wechatutil.WeChatTokenUtils;
//import com.mage.model.pojo.WeChatMessage;
//import com.mage.model.pojo.WeChatToken;
//import com.mage.model.vo.WeChatMsgResponseVo;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import javax.annotation.Resource;
//import java.util.HashMap;
//
//
///**
// * 微信订阅模板
// */
//
//@Service
//public class WeChatService {
//
//    private final Logger logger = LoggerFactory.getLogger(WeChatService.class);
//
////    @Resource(name = "cacheRedisTemplate")
////    private RedisTemplate<String, Object> cacheRedisTemplate;
//
//    @Resource
//    private RestTemplate restTemplate;
//
//    private final ProjectConfig config = new ProjectConfig();
//
//    public String getWeChatToken() throws Exception {
//
////        String token = (String)cacheRedisTemplate.opsForHash().get("wechat", "wechat_access_token");
////        cacheRedisTemplate.expire("wechat", 2, TimeUnit.HOURS);
//        String token=null;
//
//        if (token == null || "".equals(token)){
//            String requestToken = WeChatTokenUtils.requestToken();
//            WeChatToken weChatToken = JSON.parseObject(requestToken, WeChatToken.class);
//            String newToken = weChatToken.getAccessToken();
//            //cacheRedisTemplate.opsForHash().put("wechat", "wechat_access_token", newToken);
//            return newToken;
//        }
//
//        return token;
//    }
//
//    public void weChatMessageSend(WeChatMessage weChatMessage){
//
//        String token = "";
//
//        try {
//            token = getWeChatToken();
//        } catch (Exception e) {
//            logger.info("请求微信接口token失败");
//        }
//
//        HashMap<String, Object> uriVariables  = new HashMap<>(6);
//        uriVariables .put("touser", weChatMessage.getToUser());
//        uriVariables.put("template_id", weChatMessage.getTemplateId());
//        uriVariables.put("page", weChatMessage.getPage());
//        uriVariables.put("data", weChatMessage.getData());
//        uriVariables.put("miniprogram_state", weChatMessage.getMiniprogramState());
//        uriVariables.put("lang", "".equals(weChatMessage.getLang()) ? "zh_CN" : weChatMessage.getLang());
//        System.out.println("token :"+token);
//        ResponseEntity<WeChatMsgResponseVo> responseEntity = restTemplate.postForEntity("https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token="+token, uriVariables, WeChatMsgResponseVo.class);
//        WeChatMsgResponseVo body = responseEntity.getBody();
//        System.out.println(body);
//        assert body != null;
//        logger.info(body.toString());
//    }
//
//}
