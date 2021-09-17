package com.example.demo;

import com.example.demo.filter.SimpleCORSFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//
//	@Configuration
//	static
//	class WebConfig implements WebMvcConfigurer {
//
//		@Bean
//		public FilterRegistrationBean corsFilter(){
//			FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
//			filterFilterRegistrationBean.setFilter(new SimpleCORSFilter());
//			filterFilterRegistrationBean.setOrder(1);
//			filterFilterRegistrationBean.addUrlPatterns("/*");
//			return filterFilterRegistrationBean;
//		}
//	}
}
