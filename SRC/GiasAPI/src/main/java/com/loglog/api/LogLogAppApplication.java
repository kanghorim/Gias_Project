package com.loglog.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.WebApplicationInitializer;

import com.loglog.api.commons.constants.Constants;




@SpringBootApplication
@ComponentScan(basePackages= {Constants.COMM_PACKAGE, Constants.BASE_PACKAGE})
@PropertySources({
	@PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = false)    
})
@MapperScan(basePackages= {Constants.COMM_PACKAGE+".daos.mapper"})
public class LogLogAppApplication extends SpringBootServletInitializer implements WebApplicationInitializer {
	
	public LogLogAppApplication() {
		super();
		//error org.springframework.boot.web.servlet.support.errorpagefilter 硫붿떆吏� �븞�굹�삤寃� 泥섎━
		setRegisterErrorPageFilter(false);
	}
	
	public static void main(String[] args) {
		
		SpringApplication app = new SpringApplication(LogLogAppApplication.class);		
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) { 
		return builder.sources(LogLogAppApplication.class); 
	}

}
