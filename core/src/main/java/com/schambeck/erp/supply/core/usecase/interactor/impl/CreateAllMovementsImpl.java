package com.schambeck.erp.supply.core.usecase.interactor.impl;

import com.schambeck.erp.supply.core.dataprovider.MovementRepository;
import com.schambeck.erp.supply.core.entity.Movement;
import com.schambeck.erp.supply.core.usecase.generator.IdGenerator;
import com.schambeck.erp.supply.core.usecase.interactor.CreateAllMovements;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Named
@RequiredArgsConstructor
class CreateAllMovementsImpl implements CreateAllMovements {
    private final MovementRepository repository;
    private final IdGenerator idGenerator;

    @Override
    public List<Movement> execute(List<Movement> movements) {
        List<Movement> toCreate = movements.stream()
                .map(movement -> movement.toBuilder()
                        .id(idGenerator.generate())
                        .build())
                .collect(toList());
        return repository.createAll(toCreate);
    }
}
