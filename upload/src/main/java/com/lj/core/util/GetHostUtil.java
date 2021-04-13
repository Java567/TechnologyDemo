package com.lj.core.util;

import java.net.URI;

/**
 * @Description: 获得图片访问的url地址前缀
 * @author: ZYQ
 * @date: 2021/2/13 21:47
 */
public class GetHostUtil {
    public static URI getHost(URI uri) {
        URI effectiveURI = null;
        try {
            effectiveURI = new URI(uri.getScheme(), uri.getUserInfo(), uri.getHost(), uri.getPort(), null, null, null);
        } catch (Throwable var4) {
            effectiveURI = null;
        }
        return effectiveURI;
    }
}
