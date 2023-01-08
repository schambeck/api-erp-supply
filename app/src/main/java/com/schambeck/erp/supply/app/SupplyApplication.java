package com.schambeck.erp.supply.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.schambeck.erp.supply")
public class SupplyApplication {
	public static void main(String[] args) {
		SpringApplication.run(SupplyApplication.class, args);
	}
}
