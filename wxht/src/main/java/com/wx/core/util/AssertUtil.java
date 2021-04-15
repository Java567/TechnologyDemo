package com.wx.core.util;

import com.wx.core.constant.ApiConstant;
import com.wx.core.exception.ParameterException;
import org.apache.commons.lang3.StringUtils;

public class AssertUtil {


    public static void isNotEmpty(String str, String... message) {
        if (StringUtils.isBlank(str)) {
            execute(message);
        }
    }

    public static void isNotNull(Object obj, String... message) {
        if (obj == null) {
            execute(message);
        }
    }
    public static void isTrue(boolean isTrue, String... message) {
        if (isTrue) {
            execute(message);
        }
    }

    private static void execute(String... message) {
        String msg = ApiConstant.ERROR_MESSAGE;
        if (message != null && message.length > 0) {
            msg = message[0];
        }
        throw new ParameterException(msg);
    }
}
