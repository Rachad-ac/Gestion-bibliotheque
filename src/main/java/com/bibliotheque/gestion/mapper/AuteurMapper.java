package com.bibliotheque.gestion.mapper;

import com.bibliotheque.gestion.entity.AuteurEntity;
import com.bibliotheque.gestion.model.AuteurDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring")
public interface AuteurMapper extends EntityMapper<AuteurDTO, AuteurEntity> {

    @Override
    AuteurEntity asEntity(AuteurDTO dto);

    @Override
    AuteurDTO asDto(AuteurEntity entity);
}
