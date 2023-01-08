package com.schambeck.erp.supply.core.usecase.interactor;

import com.schambeck.erp.sales.core.entity.Order;

public interface ConsumeOrder {
    void execute(Order order);
}
