package com.earo.test;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication	//Spring Boot core annotation
public class SpringBootDemoApplication {

	@RequestMapping("/")
	public String index(){
		return "Hello spring boot";
	}

	public static void main(String[] args) {
        new SpringApplicationBuilder(SpringBootDemoApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run();
	}
}
