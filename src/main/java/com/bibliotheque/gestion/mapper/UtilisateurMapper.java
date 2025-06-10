package com.bibliotheque.gestion.mapper;

import com.bibliotheque.gestion.entity.UtilisateurEntity;
import com.bibliotheque.gestion.model.UtilisateurDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring" )
public interface UtilisateurMapper extends EntityMapper<UtilisateurDTO , UtilisateurEntity>{
    @Override
    UtilisateurEntity asEntity(UtilisateurDTO dto);

    @Override
    UtilisateurDTO asDto(UtilisateurEntity entity);
}
