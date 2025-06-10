package com.bibliotheque.gestion.mapper;

import com.bibliotheque.gestion.entity.BibliothequeEntity;
import com.bibliotheque.gestion.model.BibliothequeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring")
public interface BibliothequeMapper extends EntityMapper<BibliothequeDTO , BibliothequeEntity>{

    @Override
    BibliothequeEntity asEntity(BibliothequeDTO dto);

    @Override
    BibliothequeDTO asDto(BibliothequeEntity entity);
}
