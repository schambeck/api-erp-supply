package com.schambeck.erp.supply.core.usecase.interactor;

import com.schambeck.erp.supply.core.entity.Movement;

import java.util.List;

public interface CreateAllMovements {
    List<Movement> execute(List<Movement> movements);
}
