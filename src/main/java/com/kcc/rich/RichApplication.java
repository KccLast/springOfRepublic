package com.kcc.rich;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RichApplication {

	public static void main(String[] args) {
		SpringApplication.run(RichApplication.class, args);
	}

}
