package com.schambeck.erp.supply.app.dataprovider.mapper;

import com.schambeck.erp.supply.app.dataprovider.entity.MovementEntity;
import com.schambeck.erp.supply.core.entity.Movement;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(unmappedTargetPolicy = IGNORE)
public interface MovementMapper {
    MovementMapper INSTANCE = Mappers.getMapper(MovementMapper.class);

    List<Movement> toDomain(List<MovementEntity> entities);

    List<MovementEntity> toEntity(List<Movement> domains);
}
