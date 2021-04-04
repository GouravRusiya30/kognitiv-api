package com.kognitiv.backend.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = { "com.kognitiv.backend.assignment" })
public class KognitivApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(KognitivApiApplication.class, args);
	}
}
