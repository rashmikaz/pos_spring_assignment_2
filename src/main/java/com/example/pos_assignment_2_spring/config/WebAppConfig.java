package com.example.pos_assignment_2_spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "com.example.pos_assignment_2_spring")
@EnableWebMvc
public class WebAppConfig {
}
