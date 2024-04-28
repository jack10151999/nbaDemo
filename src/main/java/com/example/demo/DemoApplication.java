package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@ComponentScan(basePackages = {"com"})
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("DemoApplication!!!!!!!!!!!!!");
		SpringApplication.run(DemoApplication.class, args);
	}

}
