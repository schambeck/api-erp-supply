package com.schambeck.erp.supply.app.entrypoint.messaging;

import com.schambeck.erp.supply.app.dataprovider.mapper.OrderMsgMapper;
import com.schambeck.erp.supply.app.dataprovider.model.OrderMsg;
import com.schambeck.erp.supply.app.entrypoint.controller.OrderController;
import com.schambeck.erp.supply.core.entity.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
class OrderConsumer {
    private final OrderController controller;
    @RabbitListener(queues = "${order.queue}")
    public void receiveMessage(OrderMsg msg) {
        log.info("received: {}", msg);
        Order order = OrderMsgMapper.INSTANCE.toDomain(msg);
        controller.consume(order);
    }
}
