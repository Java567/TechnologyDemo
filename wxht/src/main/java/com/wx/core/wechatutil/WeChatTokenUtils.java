package com.wx.core.wechatutil;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.Security;
import java.util.Arrays;


@Slf4j
@Component
public class WeChatTokenUtils {
    private static ProjectConfig config;

    /**
     * 算法名称
     */
    private static final String KEY_ALGORITHM = "AES";

    /**
     * 加解密算法/模式/填充方式
     */
    private static final String ALGORITHM_STR = "AES/CBC/PKCS7Padding";


    private static final CloseableHttpClient CLIENT = HttpClients.createDefault();

    @Autowired
    public WeChatTokenUtils(ProjectConfig config) {
        WeChatTokenUtils.config = config;
    }


    /**
     * 用来向微信服务器请求session_key 等信息的方法
     *
     * @param code 前端给的code
     * @return json String
     */
    public static String request(String code) {
        try {
            URIBuilder builder = new URIBuilder(config.getWeiXinApi())
                    .addParameter("appid", config.getAppId())
                    .addParameter("secret", config.getAppSecret())
                    .addParameter("js_code", code)
                    .addParameter("grant_type", "authorization_code");
            HttpGet get = new HttpGet(builder.build());
            CloseableHttpResponse resp = CLIENT.execute(get);
            return EntityUtils.toString(resp.getEntity());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ProjectException(ResultStatus.SERVICE_ERROR, "小程序登录请求失败");
        }
    }

    /**
     * 获取微信的接口凭证 token
     * @return 微信的接口凭证
     */
    public static String requestToken() throws Exception {
        URIBuilder builder = new URIBuilder(config.getWeiXinTokenApi())
                .addParameter("appid", config.getAppId())
                .addParameter("secret", config.getAppSecret())
                .addParameter("grant_type", "client_credential");
        HttpGet get = new HttpGet(builder.build());
        CloseableHttpResponse resp = CLIENT.execute(get);
        return EntityUtils.toString(resp.getEntity());
    }

    /**
     * 解密微信用户个人信息(encryptedData)
     *
     * @param encryptedData 要解密的字符串
     * @param keyBytes      解密密钥
     * @param iv            解密向量
     */
    public static String decrypt(String encryptedData, String keyBytes, String iv) {
        byte[] encryptedText;
        try {
            Security.addProvider(new BouncyCastleProvider());
            Key key = getKey(Base64.decodeBase64(keyBytes));
            Cipher cipher = Cipher.getInstance(ALGORITHM_STR);
            cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(Base64.decodeBase64(iv)));
            encryptedText = cipher.doFinal(Base64.decodeBase64(encryptedData));
            return new String(encryptedText, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "{}";
    }


    private static Key getKey(byte[] keyBytes) {
        // 如果密钥不足16位，那么就补足
        int base = 16;
        if (keyBytes.length % base != 0) {
            int groups = keyBytes.length / base + 1;
            byte[] temp = new byte[groups * base];
            Arrays.fill(temp, (byte) 0);
            System.arraycopy(keyBytes, 0, temp, 0, keyBytes.length);
            keyBytes = temp;
        }
        // 转化成JAVA的密钥格式
        return new SecretKeySpec(keyBytes, KEY_ALGORITHM);
    }
}
