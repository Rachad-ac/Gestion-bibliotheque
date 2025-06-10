package com.bibliotheque.gestion.mapper;

import com.bibliotheque.gestion.entity.EmployeEntity;
import com.bibliotheque.gestion.model.EmployeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring" ,
        uses = {BibliothequeMapper.class})
public interface EmployeMapper extends EntityMapper<EmployeDTO , EmployeEntity> {
    @Override
    @Mapping(source = "bibliothequeId", target = "bibliotheque.id")
    EmployeEntity asEntity(EmployeDTO dto);

    @Override
    @Mapping(source = "bibliotheque.id", target = "bibliothequeId")
    EmployeDTO asDto(EmployeEntity entity);
}
