package com.gatecm.tip.config;



import java.text.SimpleDateFormat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

/**
 * @ClassName: BaseConfig
 * @Description: TODO(全局配置)
 * @author chenxiaohui
 * @date 2017年12月6日 下午10:24:36
 *
 */
//@Configuration  
//@EnableWebMvc  
//@ComponentScan(basePackages = "com.gatecm.tip") 
public class BaseConfig {

//	@Bean
//	public ObjectMapper ObjectMapper() {
//		ObjectMapper objectMapper = new ObjectMapper();
//		// 忽略json字符串中不识别的属性
//		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//		// 忽略无法转换的对象 “No serializer found for class com.xxx.xxx”
//		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
//		objectMapper.registerModule(new ParameterNamesModule());
//		objectMapper.registerModule(new Jdk8Module());
//		objectMapper.registerModule(new JavaTimeModule());
//		return objectMapper;
//	}
//	
//	@Bean
//	public MappingJackson2HttpMessageConverter mappingJacksonHttpMessageConverter() {
//		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
//		ObjectMapper objectMapper = new ObjectMapper();
//		System.err.println("===");
//		objectMapper.setSerializationInclusion(Include.NON_NULL);
//		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));  
//		mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
//		
//		return mappingJackson2HttpMessageConverter;
//	}

}
