package com.schambeck.erp.supply.core.usecase.interactor;

import com.schambeck.erp.supply.core.entity.Order;

public interface ConsumeOrder {
    void execute(Order order);
}
