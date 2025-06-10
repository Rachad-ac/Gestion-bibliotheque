package com.bibliotheque.gestion.mapper;

import com.bibliotheque.gestion.entity.EmpruntEntity;
import com.bibliotheque.gestion.model.EmpruntDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring" ,
        uses = {BibliothequeMapper.class , EmployeMapper.class , LivreMapper.class})
public interface EmpruntMapper extends EntityMapper<EmpruntDTO , EmpruntEntity>{
    @Override
    @Mapping(source = "utilisateurId", target = "utilisateur.id")
    @Mapping(source = "livreId", target = "livre.id")
    @Mapping(source = "employeId", target = "employe.id")
    EmpruntEntity asEntity(EmpruntDTO dto);

    @Override
    @Mapping(source = "utilisateur.id", target = "utilisateurId")
    @Mapping(source = "livre.id", target = "livreId")
    @Mapping(source = "employe.id", target = "employeId")
    EmpruntDTO asDto(EmpruntEntity entity);
}
