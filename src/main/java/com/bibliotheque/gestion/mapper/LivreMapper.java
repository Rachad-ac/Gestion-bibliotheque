package com.bibliotheque.gestion.mapper;

import com.bibliotheque.gestion.entity.LivreEntity;
import com.bibliotheque.gestion.model.LivreDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring" ,
        uses = {LibreryMapper.class , AuteurMapper.class})
public interface LivreMapper extends EntityMapper<LivreDTO , LivreEntity> {
    @Override
    @Mapping(source = "libreryId", target = "librery.id")
    @Mapping(source = "auteurId", target = "auteur.id")
    LivreEntity asEntity(LivreDTO dto);

    @Override
    @Mapping(source = "librery.id", target = "libreryId")
    @Mapping(source = "auteur.id", target = "auteurId")
    LivreDTO asDto(LivreEntity entity);
}
