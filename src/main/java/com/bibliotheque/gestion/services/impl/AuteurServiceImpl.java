package com.bibliotheque.gestion.services.impl;

import com.bibliotheque.gestion.entity.QAuteurEntity;
import com.bibliotheque.gestion.mapper.AuteurMapper;
import com.bibliotheque.gestion.model.AuteurDTO;
import com.bibliotheque.gestion.repository.AuteurRepository;
import com.bibliotheque.gestion.services.AuteurService;
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

@Service
@Transactional
@RequiredArgsConstructor
public class AuteurServiceImpl implements AuteurService {
    
    private final AuteurRepository auteurRepository;
    private final AuteurMapper auteurMapper;

    @Override
    public AuteurDTO createAuteur(AuteurDTO auteurDTO){
        var entity = auteurMapper.asEntity(auteurDTO);
        var entitySave = auteurRepository.save(entity);
        return auteurMapper.asDto(entitySave);
    }

    @Override
    public AuteurDTO getAuteur(Long id){
       var entity = auteurRepository.findById(id);
       return  auteurMapper.asDto(entity.get());
    }

    @Override
    public void deleteAuteur(Long id){
        if(!auteurRepository.existsById(id)){
            throw new RuntimeException("Auteur non trouver");
        }
        auteurRepository.deleteById(id);
    }

    @Override
    public AuteurDTO updateAuteur(AuteurDTO auteurDTO){
        var entity = auteurMapper.asEntity(auteurDTO);
        var entityUpdate = auteurRepository.save(entity);
        return auteurMapper.asDto(entityUpdate);
    }

    @Override
    public Page<AuteurDTO> getAllAuteur(Map<String, String> searchParams, Pageable pageable){
      var booleanBuilder = new BooleanBuilder(); 
      buildSearch(searchParams , booleanBuilder);
      return auteurRepository.findAll(booleanBuilder , pageable)
              .map(auteurMapper::asDto);
    }

    private void buildSearch(Map<String, String> searchParams, BooleanBuilder booleanBuilder) {
        if (Objects.nonNull(searchParams)) {
            var qEntity = QAuteurEntity.auteurEntity;

            if (searchParams.containsKey("nom"))
                booleanBuilder.and(qEntity.nom.containsIgnoreCase(searchParams.get("nom")));

            if (searchParams.containsKey("prenom"))
                booleanBuilder.and(qEntity.prenom.containsIgnoreCase(searchParams.get("prenom")));

            if (searchParams.containsKey("date_naiss")){
                Date date = null;
                try {
                    date = new SimpleDateFormat("yyyy-MM-dd").parse(searchParams.get("date_naiss"));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                booleanBuilder.and(qEntity.dateNaiss.eq(date));
            }
            String sexe = searchParams.get("sexe");
            if (sexe != null && !sexe.isEmpty()) {
                booleanBuilder.and(qEntity.sexe.stringValue().lower().containsIgnoreCase(sexe.toLowerCase()));
            }

            String nationalite = searchParams.get("nationalite");
            if (nationalite != null && !nationalite.isEmpty()) {
                booleanBuilder.and(qEntity.nationalite.stringValue().lower().containsIgnoreCase(nationalite.toLowerCase()));
            }
        }
    }
}
