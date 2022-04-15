package com.anz.career.wholesale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class WholesaleApplication {
	public static void main(String[] args) {
		SpringApplication.run(WholesaleApplication.class, args);
	}

}
