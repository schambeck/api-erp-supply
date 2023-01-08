package com.schambeck.erp.supply.core.usecase.interactor.impl;

import com.schambeck.erp.supply.core.dataprovider.MovementRepository;
import com.schambeck.erp.supply.core.entity.Movement;
import com.schambeck.erp.supply.core.usecase.generator.IdGenerator;
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
class CreateAllMovementsImplTest {
    @InjectMocks
    CreateAllMovementsImpl createAllMovements;
    @Mock
    MovementRepository repository;
    @Mock
    IdGenerator idGenerator;

    @Test
    void consume_ValidOrder_ShouldPass() {
        UUID movementId = UUID.fromString("dd9c24cc-b336-4f25-95de-bfd2ce7520fc");
        Movement toCreate = createMovementToInsert(Movement.builder().id(movementId));
        when(idGenerator.generate()).thenReturn(movementId);
        when(repository.createAll(List.of(toCreate))).thenReturn(List.of(toCreate));

        List<Movement> created = createAllMovements.execute(List.of(toCreate));

        assertNotNull(created);
        assertEquals(1, created.size());
        verify(idGenerator).generate();
        verify(repository).createAll(List.of(toCreate));
    }

    private static Movement createMovementToInsert(Movement.MovementBuilder builder) {
        return builder
                .orderId(UUID.fromString("dfbd0935-ae7f-49af-a39d-30b50d396e17"))
                .issuedDate(LocalDate.of(2023, JANUARY, 19))
                .orderLineId(UUID.fromString("02fe8f26-f0a8-4c06-9384-3fab8801bb3e"))
                .productId(UUID.fromString("10e408b3-b032-4ae3-9980-8eeba8468b79"))
                .quantity(new BigDecimal("3.00"))
                .build();
    }
}
