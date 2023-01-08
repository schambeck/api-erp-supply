package com.schambeck.erp.supply.core.entity;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static com.schambeck.erp.supply.core.util.MessageConstraintViolationMatcher.messageIs;
import static java.time.Month.JANUARY;
import static nl.jqno.equalsverifier.Warning.ALL_FIELDS_SHOULD_BE_USED;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MovementTest {
    @Test
    void equalsContract() {
        EqualsVerifier.simple()
                .suppress(ALL_FIELDS_SHOULD_BE_USED)
                .forClass(Movement.class)
                .verify();
    }

    @Test
    void build_NoProductId_ShouldFail() {
        Movement.MovementBuilder noProductId = createMovementToInsert(Movement.builder());

        ConstraintViolationException exception = assertThrows(ConstraintViolationException.class, noProductId::build);

        assertThat(exception.getConstraintViolations(), hasItem(messageIs("Product is required")));
    }

    private static Movement.MovementBuilder createMovementToInsert(Movement.MovementBuilder builder) {
        return builder
                .orderId(UUID.fromString("dfbd0935-ae7f-49af-a39d-30b50d396e17"))
                .issuedDate(LocalDate.of(2023, JANUARY, 19))
                .orderLineId(UUID.fromString("02fe8f26-f0a8-4c06-9384-3fab8801bb3e"))
                .quantity(new BigDecimal("3.00"));
    }
}
