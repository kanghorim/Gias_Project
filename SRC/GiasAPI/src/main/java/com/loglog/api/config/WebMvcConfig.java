package com.loglog.api.config;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.google.gson.Gson;
import com.loglog.api.commons.filter.CORSFilter;
import com.loglog.api.commons.utils.aws.AmazonS3Upload;
import com.loglog.api.commons.utils.aws.S3tool;
import com.loglog.api.config.intercepter.CommonInterceptor;
import com.loglog.api.config.intercepter.TokenCheckInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${version.build.date}")
    private String versionBuildDate;

    @Value("${mail.id}")
    private String mailId;
    @Value("${mail.pw}")
    private String mailPw;

//    @Value("${aws_access_key_id}")
//    private String accessKeyId;
//
//    @Value("${aws_secret_access_key}")
//    private String secretKey;
//
//    @Value("${aws_secret_bucket_name}")
//    private String bucketName;

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> enableDefaultServlet() {
        return (factory) -> factory.setRegisterDefaultServlet(true);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> messageConverters) {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.ALL));
        messageConverters.add(converter);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CommonInterceptor(versionBuildDate))
                .addPathPatterns("/**");
    }

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(465);
        mailSender.setDefaultEncoding("UTF-8");
        mailSender.setUsername(mailId);
        mailSender.setPassword(mailPw);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.debug", "true");
        props.put("mail.smtp.timeout", 300000);

        return mailSender;
    }

    @Bean
    public MultipartResolver configureMultipart() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSize(500000000);
        return resolver;
    }

    @Bean(name = "gson")
    public Gson gson() {
        return new Gson();
    }

//    @Bean(name = "s3tool")
//    public S3tool S3tool() {
//        AmazonS3Upload s3 = new AmazonS3Upload();
//        s3.initializeAmazonS3Upload(accessKeyId, secretKey, bucketName);
//        return s3;
//    }
}
