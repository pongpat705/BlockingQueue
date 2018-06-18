package com.maoz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages="com.maoz")
@SpringBootApplication
public class BlockingQueueApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlockingQueueApplication.class, args);
	}
}
