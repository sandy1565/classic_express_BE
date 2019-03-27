package com.classicexpress.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.classicexpress.controller","com.classicexpress.service","com.classicexpress.dao","com.classicexpress.sender"})
@EnableAutoConfiguration
public class springBoot {

	public static void main(String[] args) {
		SpringApplication.run(springBoot.class, args);
	}
	
}
