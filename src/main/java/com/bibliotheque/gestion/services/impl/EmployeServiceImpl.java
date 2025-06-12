package com.bibliotheque.gestion.services.impl;

import com.bibliotheque.gestion.entity.QEmployeEntity;
import com.bibliotheque.gestion.entity.enums.SexeType;
import com.bibliotheque.gestion.mapper.EmployeMapper;
import com.bibliotheque.gestion.model.EmployeDTO;
import com.bibliotheque.gestion.repository.EmployeRepository;
import com.bibliotheque.gestion.services.EmployeService;
import com.querydsl.core.BooleanBuilder;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeoutException;

@Transactional
@RequiredArgsConstructor
@Service
public class EmployeServiceImpl implements EmployeService {

    private final EmployeRepository employeRepository;
    private final EmployeMapper employeMapper;

    @Override
    public EmployeDTO createEmploye(EmployeDTO employeDTO){
        var entity = employeMapper.asEntity(employeDTO);
        var entitySave = employeRepository.save(entity);
        return employeMapper.asDto(entitySave);
    }

    @Override
    public EmployeDTO getEmploye(Long id){
        var entity = employeRepository.findById(id);
        return employeMapper.asDto(entity.get());
    }

    @Override
    public void deleteEmploye(Long id){
        if(!employeRepository.existsById(id)){
            throw new RuntimeException("employe non trouver");
        }
        employeRepository.deleteById(id);
    }

    @Override
    public EmployeDTO updateEmploye(EmployeDTO employeDTO){
        var entity = employeMapper.asEntity(employeDTO);
        var entityUpdate = employeRepository.save(entity);
        return employeMapper.asDto(entityUpdate);
    }

    @Override
    public Page<EmployeDTO> getAllEmploye(Map<String, String> searchParams, Pageable pageable){
        var booleanBuilder = new BooleanBuilder();
        buildSearch(searchParams, booleanBuilder);
        return employeRepository.findAll(booleanBuilder, pageable)
                .map(employeMapper::asDto);
    }

    private void buildSearch(Map<String, String> searchParams, BooleanBuilder booleanBuilder) {
        if (Objects.nonNull(searchParams)) {
            var qEntity = QEmployeEntity.employeEntity;

            if (searchParams.containsKey("nom"))
                booleanBuilder.and(qEntity.nom.containsIgnoreCase(searchParams.get("nom")));

            if (searchParams.containsKey("prenom"))
                booleanBuilder.and(qEntity.prenom.containsIgnoreCase(searchParams.get("prenom")));

            if (searchParams.containsKey("sexe"))
                booleanBuilder.and(qEntity.sexe.eq(SexeType.valueOf(searchParams.get("sexe"))));

            if (searchParams.containsKey("email"))
                booleanBuilder.and(qEntity.email.containsIgnoreCase(searchParams.get("email")));

            if (searchParams.containsKey("telephone"))
                booleanBuilder.and(qEntity.telephone.containsIgnoreCase(searchParams.get("telephone")));

            if (searchParams.containsKey("poste"))
                booleanBuilder.and(qEntity.poste.containsIgnoreCase(searchParams.get("poste")));

            if (searchParams.containsKey("salaire")) {
                try {
                    double montant = Double.parseDouble(searchParams.get("salaire"));
                    booleanBuilder.and(qEntity.salaire.eq(montant));
                } catch (NumberFormatException e) {
                    throw new RuntimeException("Le montant net doit être un nombre valide", e);
                }
            }

            if (searchParams.containsKey("dateEmboche")){
                Date date = null;
                try {
                    date = new SimpleDateFormat("yyyy-MM-dd").parse(searchParams.get("dateEmboche"));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                booleanBuilder.and(qEntity.dateEmboche.eq(date));
            }

            String sexe = searchParams.get("sexe");
            if (sexe != null && !sexe.isEmpty()) {
                booleanBuilder.and(qEntity.sexe.stringValue().lower().containsIgnoreCase(sexe.toLowerCase()));
            }

        }
    }


}
