package com.schambeck.erp.supply.app.dataprovider.entity;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static nl.jqno.equalsverifier.Warning.SURROGATE_KEY;

class MovementEntityTest {
    @Test
    void equalsContract() {
        EqualsVerifier.simple()
                .forClass(MovementEntity.class)
                .withPrefabValues(MovementEntity.class, new MovementEntity(UUID.fromString("ceea6a32-7e5a-4c39-9b3a-a1ad000148d2")), new MovementEntity(UUID.fromString("12025f35-4d6a-42d8-9e86-97dfbd27b80f")))
                .suppress(SURROGATE_KEY)
                .verify();
    }
}
