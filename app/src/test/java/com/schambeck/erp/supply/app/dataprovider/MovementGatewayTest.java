package com.schambeck.erp.supply.app.dataprovider;

import com.schambeck.erp.supply.app.dataprovider.entity.MovementEntity;
import com.schambeck.erp.supply.core.entity.Movement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static java.time.Month.JANUARY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MovementGatewayTest {
    @InjectMocks
    MovementGateway movementGateway;
    @Mock
    JpaMovementRepository jpaRepository;

    @Test
    void saveAll_ValidMovements_ShouldPass() {
        MovementEntity entityToCreate = createMovementToInsert(MovementEntity.builder());
        when(jpaRepository.saveAll(List.of(entityToCreate))).thenReturn(List.of(entityToCreate));

        Movement domainToCreate = createMovementToInsert(Movement.builder());
        List<Movement> createdDomain = movementGateway.createAll(List.of(domainToCreate));

        assertNotNull(createdDomain);
        assertEquals(1, createdDomain.size());
        verify(jpaRepository).saveAll(List.of(entityToCreate));
    }

    private static MovementEntity createMovementToInsert(MovementEntity.MovementEntityBuilder builder) {
        return builder
                .id(UUID.fromString("5411d288-0d1e-4140-b298-8807eaf9a6e0"))
                .orderId(UUID.fromString("dfbd0935-ae7f-49af-a39d-30b50d396e17"))
                .issuedDate(LocalDate.of(2023, JANUARY, 19))
                .orderLineId(UUID.fromString("02fe8f26-f0a8-4c06-9384-3fab8801bb3e"))
                .productId(UUID.fromString("10e408b3-b032-4ae3-9980-8eeba8468b79"))
                .quantity(new BigDecimal("3.00"))
                .build();
    }

    private static Movement createMovementToInsert(Movement.MovementBuilder builder) {
        return builder
                .id(UUID.fromString("5411d288-0d1e-4140-b298-8807eaf9a6e0"))
                .orderId(UUID.fromString("dfbd0935-ae7f-49af-a39d-30b50d396e17"))
                .issuedDate(LocalDate.of(2023, JANUARY, 19))
                .orderLineId(UUID.fromString("02fe8f26-f0a8-4c06-9384-3fab8801bb3e"))
                .productId(UUID.fromString("10e408b3-b032-4ae3-9980-8eeba8468b79"))
                .quantity(new BigDecimal("3.00"))
                .build();
    }
}
