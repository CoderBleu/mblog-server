package com.mblog.core.web.config;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @author lauy
 * @date 2022/8/31
 * @description
 */
public class LocalDateTimeGlobalSerializerConfig implements ObjectSerializer {

    public static final LocalDateTimeGlobalSerializerConfig INSTANCE = new LocalDateTimeGlobalSerializerConfig();

    @Override
    public void write(JSONSerializer jsonSerializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        SerializeWriter out = jsonSerializer.out;
        if (object == null) {
            out.writeNull();
        } else {
            LocalDateTime result = (LocalDateTime) object;
            out.write(String.valueOf(result.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()));
        }
    }
}
