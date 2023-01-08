package com.schambeck.erp.supply.app.dataprovider;

import com.schambeck.erp.supply.app.dataprovider.entity.MovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaMovementRepository extends JpaRepository<MovementEntity, UUID> {
}
