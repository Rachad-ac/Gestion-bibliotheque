package com.bibliotheque.gestion.mapper;

import com.bibliotheque.gestion.entity.LibreryEntity;
import com.bibliotheque.gestion.model.LibreryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring")
public interface LibreryMapper extends EntityMapper<LibreryDTO, LibreryEntity>{

    @Override
    LibreryEntity asEntity(LibreryDTO dto);

    @Override
    LibreryDTO asDto(LibreryEntity entity);
}
