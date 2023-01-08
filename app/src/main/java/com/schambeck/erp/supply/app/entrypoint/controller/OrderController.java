package com.schambeck.erp.supply.app.entrypoint.controller;

import com.schambeck.erp.supply.app.entrypoint.controller.mapper.OrderWebMapper;
import com.schambeck.erp.supply.app.entrypoint.controller.model.OrderWeb;
import com.schambeck.erp.supply.core.entity.Order;
import com.schambeck.erp.supply.core.usecase.interactor.CloseOrder;
import com.schambeck.erp.supply.core.usecase.interactor.ConsumeOrder;
import com.schambeck.erp.supply.core.usecase.interactor.CreateOrder;
import com.schambeck.erp.supply.core.usecase.interactor.FindOrder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderController {
    private final CreateOrder create;
    private final CloseOrder close;
    private final FindOrder find;
    private final ConsumeOrder consume;

    public OrderWeb create(OrderWeb web) {
        var order = OrderWebMapper.INSTANCE.toDomain(web);
        OrderWeb created = OrderWebMapper.INSTANCE.toWeb(create.execute(order));
        log.info("create: {}", created);
        return created;
    }

    public void close(UUID id) {
        close.execute(id);
        log.info("close: {}", id);
    }

    public OrderWeb findById(UUID id) {
        OrderWeb web = OrderWebMapper.INSTANCE.toWeb(find.findById(id));
        log.info("findById: {}", web);
        return web;
    }

    public List<OrderWeb> findAll() {
        List<OrderWeb> webs = OrderWebMapper.INSTANCE.toWeb(find.findAll());
        log.info("findAll: {}", webs);
        return webs;
    }

    public void consume(Order order) {
        log.info("consume: {}", order);
        consume.execute(order);
    }
}
