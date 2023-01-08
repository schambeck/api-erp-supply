package com.schambeck.erp.supply.app;

import com.schambeck.erp.supply.app.config.RabbitTestConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Import(RabbitTestConfiguration.class)
class SupplyApplicationIT {
	@Autowired
	private SupplyApplication context;

	@Test
	void contextLoads() {
		assertNotNull(context);
	}
}
