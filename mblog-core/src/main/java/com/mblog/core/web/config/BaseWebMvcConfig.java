package com.mblog.core.web.config;

import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.annotation.RequestParamMapMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lauy
 * @date 2022/8/29
 * @description
 * //@Configuration
 */
@EnableAspectJAutoProxy
public class BaseWebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                //.allowCredentials(false) 是否允许跨域请求携带cookie(当allowedOrigins的值为【*】时，这里只能为false)
                .maxAge(3600)
                .allowedHeaders("*");
    }


    /**
     * SerializerFeature.WriteMapNullValue, // 显示空字段
     * SerializerFeature.WriteNullStringAsEmpty, // 字符串类型字段为null时输出""而非null
     * SerializerFeature.WriteNullBooleanAsFalse, // Boolean类型字段为null时输出false而null
     * SerializerFeature.PrettyFormat, // 美化json输出，否则会作为整行输出
     * SerializerFeature.WriteNullNumberAsZero, // 数值字段如果为null,输出为0,而非null
     * @return
     */
    public FastJsonHttpMessageConverter fastConverter() {
        // 定义一个convert转换消息的对象
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        // 添加fastJson的配置信息
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        SerializeConfig serializeConfig = SerializeConfig.globalInstance;
        serializeConfig.put(LocalDateTime.class, LocalDateTimeGlobalSerializerConfig.INSTANCE);
        fastJsonConfig.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect);
        fastJsonConfig.setCharset(StandardCharsets.UTF_8);
        fastJsonConfig.setSerializeConfig(serializeConfig);
        // 反序列化
        ParserConfig parserConfig = ParserConfig.getGlobalInstance();
        // 开启SafeMode
        parserConfig.setSafeMode(true);
        fastJsonConfig.setParserConfig(parserConfig);
        fastConverter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        fastConverter.setFastJsonConfig(fastJsonConfig);
        return fastConverter;
    }


    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        List<HttpMessageConverter<?>> cleanHttpMessageConverterList = converters.stream()
                .filter(converter -> converter instanceof MappingJackson2HttpMessageConverter)
                .collect(Collectors.toList());
        converters.removeAll(cleanHttpMessageConverterList);
        // 添加fastjson converter
        converters.add(fastConverter());
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new RequestParamMapMethodArgumentResolver());
    }
}
