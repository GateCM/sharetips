/**
 * 
 */
package com.gatecm.tip.config;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gatecm.tip.constant.BaseConstant;
import com.gatecm.tip.interceptor.MyInterceptor;

/**
 * @Description: TODO(MVC配置)
 * @author chenxiaohui
 * @date 2017年10月11日 上午10:23:59
 *
 */
@Configuration
public class MVCConfiguration extends WebMvcConfigurationSupport {

	/**
	 * 发现如果继承了WebMvcConfigurationSupport，则在yml中配置的相关内容会失效。
	 * 
	 * @param registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/plugin/**").addResourceLocations("classpath:/static/plugin/");
		registry.addResourceHandler("/custom/**").addResourceLocations("classpath:/static/custom/");
	}

	/**
	 * 拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/login/page",
				"/error/**", "/plugin/**", "/custom/**");
		super.addInterceptors(registry);
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setTimeZone(TimeZone.getTimeZone(BaseConstant.TIME_ZONE));
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.setDateFormat(new SimpleDateFormat(BaseConstant.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS));
		mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
		converters.add(mappingJackson2HttpMessageConverter);
	}

}
