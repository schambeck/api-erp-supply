package com.schambeck.erp.supply.app.entrypoint.controller;

import com.schambeck.erp.supply.core.entity.Order;
import com.schambeck.erp.supply.core.usecase.interactor.ConsumeOrder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderController {
    private final ConsumeOrder consume;

    public void consume(Order order) {
        log.info("consume: {}", order);
        consume.execute(order);
    }
}
