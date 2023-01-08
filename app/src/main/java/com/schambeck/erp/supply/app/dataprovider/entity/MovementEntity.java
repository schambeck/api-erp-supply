package com.schambeck.erp.supply.app.dataprovider.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "MOVEMENT")
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class MovementEntity {
    public MovementEntity(UUID id) {
        this.id = id;
    }

    @Id
    @Column(name = "ID")
    @NotNull(message = "Id is required")
    private UUID id;
    @Column(name = "ORDER_ID")
    @NotNull(message = "Order is required")
    private UUID orderId;
    @Column(name = "ISSUED_DATE")
    @NotNull(message = "Issued date is required")
    private LocalDate issuedDate;
    @Column(name = "ORDER_LINE_ID")
    @NotNull(message = "Item is required")
    private UUID orderLineId;
    @Column(name = "PRODUCT_ID")
    @NotNull(message = "Product is required")
    private UUID productId;
    @Column(name = "QUANTITY")
    @NotNull(message = "Quantity is required")
    private BigDecimal quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovementEntity that = (MovementEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
