package icu.nickxiao.rest.config;

import icu.nickxiao.web.log.UserOperationLogInterceptor;
import java.util.List;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @author xiaoyi03 <xiaoyi03@kuaishou.com>
 * Created on 2021-12-12
 */
@Configuration
@PropertySource(value = {"classpath:cors.properties"})
@RequiredArgsConstructor
public class CustomMvcConfig implements WebMvcConfigurer {

    private final Environment env;

    private final UserOperationLogInterceptor userOperationLogInterceptor;

    /**
     * 自定义json转换
     *
     * @param converters HttpMessageConverter
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        ObjectMapper objectMapper = null;
        for (HttpMessageConverter converter : converters) {
            if (converter instanceof MappingJackson2HttpMessageConverter) {
                MappingJackson2HttpMessageConverter jacksonConverter =
                        ((MappingJackson2HttpMessageConverter) converter);

                if (objectMapper == null) {
                    objectMapper = jacksonConverter.getObjectMapper();
                    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
                    objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
                    objectMapper.enable(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN);
                    objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
                } else {
                    jacksonConverter.setObjectMapper(objectMapper);
                }
            }
        }
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userOperationLogInterceptor)
                .addPathPatterns("/**");
    }


    /**
     * cors配置
     * 测试版允许所有ip访问
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //项目中的所有接口都支持跨域
        registry.addMapping(env.getProperty("addMapping"))
                //所有地址都可以访问，也可以配置具体地址
                .allowedOriginPatterns(env.getProperty("allowedOriginPatterns"))
                .allowCredentials(env.getProperty("allowCredentials", boolean.class))
                //"GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS"
                .allowedMethods(env.getProperty("allowedMethods"))
                // 跨域允许时间
                .maxAge(env.getProperty("maxAge", long.class));
    }

/*    @Bean
    @Qualifier(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_BEAN_NAME)
    public DispatcherServlet dispatcherServlet() {
        return new CustomDispatcherServlet();
    }*/

}