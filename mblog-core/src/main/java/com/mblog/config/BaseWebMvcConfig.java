package com.mblog.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.pattern.PathPatternParser;

/**
 * @author lauy
 */
@Configuration
public class BaseWebMvcConfig implements WebMvcConfigurer, ApplicationContextAware {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }

    //@Bean
    //public CorsWebFilter corsFilter() {
    //    CorsConfiguration config = new CorsConfiguration();
    //    config.addAllowedMethod("*");
    //    config.addAllowedOrigin("*");
    //    config.addAllowedHeader("*");
    //
    //    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
    //    source.registerCorsConfiguration("/**", config);
    //    return new CorsWebFilter(source);
    //}

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
