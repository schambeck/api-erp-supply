package com.schambeck.erp.supply.core.entity;

import lombok.*;

import javax.validation.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Movement implements Serializable {
    private UUID id;
    @NotNull(message = "Order is required")
    private UUID orderId;
    @NotNull(message = "Issued date is required")
    private LocalDate issuedDate;
    @NotNull(message = "Item is required")
    private UUID orderLineId;
    @ToString.Include
    @NotNull(message = "Product is required")
    private UUID productId;
    @NotNull(message = "Quantity is required")
    @ToString.Include
    private BigDecimal quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movement movement = (Movement) o;
        return Objects.equals(id, movement.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static Movement.MovementBuilder builder() {
        return new Movement.CustomBuilder();
    }

    public static class CustomBuilder extends Movement.MovementBuilder {
        @Override
        public Movement build() {
            Movement built = super.build();
            validate(built);
            return built;
        }

        private void validate(Movement movement) {
            try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Movement>> violations = validator.validate(movement);
                if (!violations.isEmpty()) {
                    throw new ConstraintViolationException("Constraint validation", violations);
                }
            }
        }
    }
}
