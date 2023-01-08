package com.schambeck.erp.supply.core.usecase.generator.impl;

import com.schambeck.erp.supply.core.usecase.generator.IdGenerator;

import javax.inject.Named;
import java.util.UUID;

@Named
class UuidGenerator implements IdGenerator {
	@Override
	public UUID generate() {
		return UUID.randomUUID();
	}
}
