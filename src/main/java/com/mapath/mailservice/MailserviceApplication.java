package com.mapath.mailservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class MailserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailserviceApplication.class, args);
	}
}
