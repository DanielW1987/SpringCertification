package com.wagner.annotationconfig.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackages = "com.wagner.annotationconfig")
@Configuration
@PropertySource("classpath:sport.properties")
public class ApplicationConfig {
}
