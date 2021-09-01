package com.mocadev.jpabook.jpashop.domain;

import com.mocadev.jpabook.jpashop.exception.handler.MyHandlerExceptionResolver;
import com.mocadev.jpabook.jpashop.typeconverter.converter.IntegerToStringConverter;
import com.mocadev.jpabook.jpashop.typeconverter.converter.StringToIntegerConverter;
import com.mocadev.jpabook.jpashop.typeconverter.converter.StringToIpPortConverter;
import com.mocadev.jpabook.jpashop.web.filter.LogFilter;
import com.mocadev.jpabook.jpashop.web.filter.LoginCheckFilter;
import java.util.List;
import javax.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-08-19
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {

//	@Override
//	public void addInterceptors(
//		InterceptorRegistry registry) {
//		registry.addInterceptor(new LogInInterceptor())
//			.order(1)
//			.addPathPatterns("/**")
//			.excludePathPatterns("/css/**", "/*.ico", "/error");
//
//		registry.addInterceptor(new LoginCheckInterceptor())
//			.order(2)
//			.addPathPatterns("/**")
//			.excludePathPatterns("/", "/members/add", "/login", "/logout",
//				"/css/**", "/*.ico", "/error");
//	}

//	@Bean
	public FilterRegistrationBean logFilter() {
		FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
		filterFilterRegistrationBean.setFilter(new LogFilter());
		filterFilterRegistrationBean.setOrder(1);
		filterFilterRegistrationBean.addUrlPatterns("/*");
		return filterFilterRegistrationBean;
	}

//	@Bean
	public FilterRegistrationBean loginCheckFilter() {
		FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
		filterFilterRegistrationBean.setFilter(new LoginCheckFilter());
		filterFilterRegistrationBean.setOrder(1);
		filterFilterRegistrationBean.addUrlPatterns("/*");
		return filterFilterRegistrationBean;
	}

	@Override
	public void extendHandlerExceptionResolvers(
		List<HandlerExceptionResolver> resolvers) {
		resolvers.add(new MyHandlerExceptionResolver());
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new StringToIntegerConverter());
		registry.addConverter(new IntegerToStringConverter());
		registry.addConverter(new StringToIpPortConverter());
	}

}
