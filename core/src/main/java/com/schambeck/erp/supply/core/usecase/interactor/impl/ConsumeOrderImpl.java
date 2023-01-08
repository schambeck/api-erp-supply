package com.schambeck.erp.supply.core.usecase.interactor.impl;

import com.schambeck.erp.supply.core.dataprovider.MovementRepository;
import com.schambeck.erp.supply.core.entity.Movement;
import com.schambeck.erp.supply.core.entity.Order;
import com.schambeck.erp.supply.core.entity.OrderLine;
import com.schambeck.erp.supply.core.usecase.generator.IdGenerator;
import com.schambeck.erp.supply.core.usecase.interactor.ConsumeOrder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Named;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@Named
@RequiredArgsConstructor
class ConsumeOrderImpl implements ConsumeOrder {
    private final MovementRepository repository;
    private final IdGenerator idGenerator;
    @Override
    public void execute(Order order) {
        log.info("received: {}", order);
        repository.createAll(createMovements(order));
    }

    private List<Movement> createMovements(Order order) {
        return order.getItems().stream()
                .map(orderLine -> createMovement(order, orderLine))
                .collect(toList());
    }

    private Movement createMovement(Order order, OrderLine orderLine) {
        return Movement.builder()
                .id(idGenerator.generate())
                .orderId(order.getId())
                .issuedDate(order.getIssuedDate())
                .orderLineId(orderLine.getId())
                .productId(orderLine.getProductId())
                .quantity(orderLine.getQuantity())
                .build();
    }
}
