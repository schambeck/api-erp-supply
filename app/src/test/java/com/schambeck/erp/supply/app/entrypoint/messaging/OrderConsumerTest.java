package com.schambeck.erp.supply.app.entrypoint.messaging;

import com.schambeck.erp.supply.app.dataprovider.entity.StatusOrder;
import com.schambeck.erp.supply.app.dataprovider.model.OrderLineMsg;
import com.schambeck.erp.supply.app.dataprovider.model.OrderMsg;
import com.schambeck.erp.supply.app.entrypoint.controller.OrderController;
import com.schambeck.erp.supply.core.entity.Order;
import com.schambeck.erp.supply.core.entity.OrderLine;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static com.schambeck.erp.supply.core.entity.vo.StatusOrder.CLOSED;
import static java.time.Month.JANUARY;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class OrderConsumerTest {
    @InjectMocks
    OrderConsumer orderConsumer;
    @Mock
    OrderController controller;

    @Test
    void receive_ValidOrder_ShouldPass() {
        Order closedOrder = createClosedOrder();
        doNothing().when(controller).consume(closedOrder);

        OrderMsg closedOrderMsg = createClosedOrderMsg();
        orderConsumer.receiveMessage(closedOrderMsg);

        verify(controller).consume(closedOrder);
    }

    private static Order createClosedOrder() {
        return Order.builder()
                .id(UUID.fromString("dd9c24cc-b336-4f25-95de-bfd2ce7520fc"))
                .clientId(UUID.fromString("89fc02d7-af79-473a-a792-ce4d6c188527"))
                .issuedDate(LocalDate.of(2023, JANUARY, 19))
                .status(CLOSED)
                .item(OrderLine.builder()
                        .id(UUID.fromString("02fe8f26-f0a8-4c06-9384-3fab8801bb3e"))
                        .productId(UUID.fromString("10e408b3-b032-4ae3-9980-8eeba8468b79"))
                        .quantity(new BigDecimal("3.00"))
                        .price(new BigDecimal("1.50"))
                        .build())
                .build();
    }

    private static OrderMsg createClosedOrderMsg() {
        return OrderMsg.builder()
                .id(UUID.fromString("dd9c24cc-b336-4f25-95de-bfd2ce7520fc"))
                .clientId(UUID.fromString("89fc02d7-af79-473a-a792-ce4d6c188527"))
                .issuedDate(LocalDate.of(2023, JANUARY, 19))
                .status(StatusOrder.CLOSED)
                .item(OrderLineMsg.builder()
                        .id(UUID.fromString("02fe8f26-f0a8-4c06-9384-3fab8801bb3e"))
                        .productId(UUID.fromString("10e408b3-b032-4ae3-9980-8eeba8468b79"))
                        .quantity(new BigDecimal("3.00"))
                        .price(new BigDecimal("1.50"))
                        .build())
                .build();
    }
}
