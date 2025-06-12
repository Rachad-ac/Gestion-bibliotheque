package com.bibliotheque.gestion.services.impl;

import com.bibliotheque.gestion.entity.QAbonneEntity;
import com.bibliotheque.gestion.entity.enums.SexeType;
import com.bibliotheque.gestion.mapper.AbonneMapper;
import com.bibliotheque.gestion.model.AbonneDTO;
import com.bibliotheque.gestion.repository.AbonneRepository;
import com.bibliotheque.gestion.services.AbonneService;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

@Transactional
@RequiredArgsConstructor
@Service
public class AbonneServiceImpl implements AbonneService {

    private final AbonneRepository abonneRepository;
    private final AbonneMapper abonneMapper;

    @Override
    public AbonneDTO createAbonne(AbonneDTO abonneDTO){
        var entity = abonneMapper.asEntity(abonneDTO);
        var entitySave = abonneRepository.save(entity);
        return abonneMapper.asDto(entitySave);
    }

    @Override
    public AbonneDTO updateAbonne(AbonneDTO abonneDTO){
        var entity = abonneMapper.asEntity(abonneDTO);
        var entityUpdate = abonneRepository.save(entity);
        return abonneMapper.asDto(entityUpdate);
    }

    @Override
    public void deleteAbonne(Long id){
        if(!abonneRepository.existsById(id)){
            throw new RuntimeException("Abonne non trouve");
        }
        abonneRepository.deleteById(id);
    }

    @Override
    public AbonneDTO getAbonne(Long id){
        var entity = abonneRepository.findById(id);
        return abonneMapper.asDto(entity.get());
    }

    @Override
    public Page<AbonneDTO> getAllAbonne(Map<String, String> searchParams, Pageable pageable){
        var booleanBuilder = new BooleanBuilder();
        buildSearch(searchParams, booleanBuilder);
        return abonneRepository.findAll(booleanBuilder, pageable)
                .map(abonneMapper::asDto);
    }

    private void buildSearch(Map<String, String> searchParams, BooleanBuilder booleanBuilder) {
        if (Objects.nonNull(searchParams)) {
            var qEntity = QAbonneEntity.abonneEntity;

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

            if (searchParams.containsKey("dateInscri")){
                Date date = null;
                try {
                    date = new SimpleDateFormat("yyyy-MM-dd").parse(searchParams.get("dateInscri"));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                booleanBuilder.and(qEntity.dateInscri.eq(date));
            }

            String sexe = searchParams.get("sexe");
            if (sexe != null && !sexe.isEmpty()) {
                booleanBuilder.and(qEntity.sexe.stringValue().lower().containsIgnoreCase(sexe.toLowerCase()));
            }

        }
    }


}
