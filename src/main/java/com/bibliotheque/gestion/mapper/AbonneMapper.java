package com.bibliotheque.gestion.mapper;

import com.bibliotheque.gestion.entity.AbonneEntity;
import com.bibliotheque.gestion.model.AbonneDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring" ,
        uses = {LibreryMapper.class})
public interface AbonneMapper extends EntityMapper<AbonneDTO, AbonneEntity>{
    @Override
    @Mapping(source = "libreryId", target = "librery.id")
    AbonneEntity asEntity(AbonneDTO dto);

    @Override
    @Mapping(source = "librery.id", target = "libreryId")
    AbonneDTO asDto(AbonneEntity entity);
}
