package com.schambeck.erp.sales.app.dataprovider.model;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder(toBuilder = true)
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineMsg {
    @NotNull(message = "Product is required")
    private UUID productId;
    @NotNull(message = "Quantity is required")
    private BigDecimal quantity;
    @NotNull(message = "Price is required")
    private BigDecimal price;
    private BigDecimal cost;
}
