package com.wx.core.convert;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.wx.core.exception.ParameterException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

/**
 * 自定义Jackson反序列化日期类型时应用的类型转换器,一般用于@RequestBody接受参数时使用
 */
public class DateJacksonConverter extends JsonDeserializer<Date> {
    private static String[] pattern =
            new String[]{"yyyy-MM-dd", "yyyy-MM-dd HH:mm", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss.S",
                    "yyyy.MM.dd", "yyyy.MM.dd HH:mm", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm:ss.S",
                    "yyyy/MM/dd", "yyyy/MM/dd HH:mm", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss.S"};
 
    @Override
    public Date deserialize(JsonParser p, DeserializationContext context)
            throws IOException, JsonProcessingException {
 
        String originDate = p.getText();
        if (StringUtils.isBlank(originDate)) {
            return null;
        }
        Date targetDate = null;
        try {
            long longDate = Long.valueOf(originDate);
            targetDate = new Date(longDate);
        } catch (NumberFormatException e) {
            try {
                targetDate = DateUtils.parseDate(originDate, DateJacksonConverter.pattern);
            } catch (ParseException ex) {
                throw new ParameterException(
                        String.format("Does not exists such as datetime pattern:{%s}",
                                originDate));
            }
        }
        return targetDate;
    }
 
    @Override
    public Class<?> handledType() {
        return Date.class;
    }
}