package com.gvr.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.gvr.test.interceptor.ApiCounterInterceptor;

@SpringBootApplication
public class GvrTestApplication extends WebMvcConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(GvrTestApplication.class, args);
	}
	
	@Autowired
    ApiCounterInterceptor apiCounterInterceptor;
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiCounterInterceptor);
    }
}
