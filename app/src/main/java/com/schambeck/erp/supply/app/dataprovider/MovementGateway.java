package com.schambeck.erp.supply.app.dataprovider;

import com.schambeck.erp.supply.app.dataprovider.entity.MovementEntity;
import com.schambeck.erp.supply.app.dataprovider.mapper.MovementMapper;
import com.schambeck.erp.supply.core.dataprovider.MovementRepository;
import com.schambeck.erp.supply.core.entity.Movement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MovementGateway implements MovementRepository {
	private final JpaMovementRepository jpaRepository;

	@Override
	public List<Movement> createAll(List<Movement> movements) {
		log.info("createAll: {}", movements);
		List<MovementEntity> entities = MovementMapper.INSTANCE.toEntity(movements);
		List<MovementEntity> created = jpaRepository.saveAll(entities);
		return MovementMapper.INSTANCE.toDomain(created);
	}
}
