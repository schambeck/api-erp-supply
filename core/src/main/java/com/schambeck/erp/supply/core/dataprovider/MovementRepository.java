package com.schambeck.erp.supply.core.dataprovider;

import com.schambeck.erp.supply.core.entity.Movement;

import java.util.List;

public interface MovementRepository {
    List<Movement> createAll(List<Movement> movements);
}
