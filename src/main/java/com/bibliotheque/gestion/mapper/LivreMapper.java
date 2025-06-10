package com.bibliotheque.gestion.mapper;

import com.bibliotheque.gestion.entity.LivreEntity;
import com.bibliotheque.gestion.model.LivreDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring" ,
        uses = {BibliothequeMapper.class , AuteurMapper.class})
public interface LivreMapper extends EntityMapper<LivreDTO , LivreEntity> {
    @Override
    @Mapping(source = "bibliothequeId", target = "bibliotheque.id")
    @Mapping(source = "auteurId", target = "auteur.id")
    LivreEntity asEntity(LivreDTO dto);

    @Override
    @Mapping(source = "bibliotheque.id", target = "bibliothequeId")
    @Mapping(source = "auteur.id", target = "auteurId")
    LivreDTO asDto(LivreEntity entity);
}
