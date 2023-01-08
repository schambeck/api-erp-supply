package com.schambeck.erp.supply.app.dataprovider.mapper;

import com.schambeck.erp.supply.app.dataprovider.model.OrderLineMsg;
import com.schambeck.erp.supply.app.dataprovider.model.OrderMsg;
import com.schambeck.erp.supply.core.entity.Order;
import com.schambeck.erp.supply.core.entity.OrderLine;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMsgMapper {
    OrderMsgMapper INSTANCE = Mappers.getMapper(OrderMsgMapper.class);

    @Mapping(target = "item", ignore = true)
    @Mapping(target = "items", ignore = true)
    Order toDomain(OrderMsg msg);

    List<OrderLine> mapFromMsg(List<OrderLineMsg> items);

    @AfterMapping
    default void mapItems(@MappingTarget Order.OrderBuilder domain, OrderMsg msg) {
        domain.items(mapFromMsg(msg.getItems()));
    }
}
