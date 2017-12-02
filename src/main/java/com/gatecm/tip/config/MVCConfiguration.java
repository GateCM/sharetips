/**
 * 
 */
package com.gatecm.tip.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import com.gatecm.tip.interceptor.MyInterceptor;

/**
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2017年10月11日 上午10:23:59
 *
 */
@Configuration
public class MVCConfiguration extends WebMvcConfigurationSupport{
	
	 /**
	   * 发现如果继承了WebMvcConfigurationSupport，则在yml中配置的相关内容会失效。
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
				"/error/**","/plugin/**","/custom/**");
		super.addInterceptors(registry);
	}

}
