package com.schambeck.erp.supply.core.dataprovider;

import com.schambeck.erp.supply.core.entity.Movement;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MovementRepository {
    List<Movement> createAll(List<Movement> movements);
    Movement create(Movement movement);
    Optional<Movement> findById(UUID id);
    List<Movement> findAll();
}
