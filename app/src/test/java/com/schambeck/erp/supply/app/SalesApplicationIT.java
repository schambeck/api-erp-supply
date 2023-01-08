package com.schambeck.erp.supply.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SupplyApplicationIT {
	@Autowired
	private SupplyApplication context;

	@Test
	void contextLoads() {
		assertNotNull(context);
	}
}
