package com.bibliotheque.gestion.services.impl;

import com.bibliotheque.gestion.entity.QEmpruntEntity;
import com.bibliotheque.gestion.mapper.EmpruntMapper;
import com.bibliotheque.gestion.model.EmpruntDTO;
import com.bibliotheque.gestion.repository.EmpruntRepository;
import com.bibliotheque.gestion.services.EmpruntService;
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
public class EmpruntServiceImpl implements EmpruntService {

    private final EmpruntRepository empruntRepository;
    private final EmpruntMapper empruntMapper;

    @Override
    public EmpruntDTO createEmprunt(EmpruntDTO empruntDTO){
        var entity = empruntMapper.asEntity(empruntDTO);
        var entitySave = empruntRepository.save(entity);
        return empruntMapper.asDto(entitySave);
    }

    @Override
    public EmpruntDTO getEmprunt(Long id){
        var entity = empruntRepository.findById(id);
        return empruntMapper.asDto(entity.get());
    }

    @Override
    public void deleteEmprunt(Long id){
        if(!empruntRepository.existsById(id)){
            throw new RuntimeException("employe non trouver");
        }
        empruntRepository.deleteById(id);
    }

    @Override
    public EmpruntDTO updateEmprunt(EmpruntDTO empruntDTO){
        var entity = empruntMapper.asEntity(empruntDTO);
        var entityUpdate = empruntRepository.save(entity);
        return empruntMapper.asDto(entityUpdate);
    }
    @Override
    public Page<EmpruntDTO> getAllEmprunt(Map<String, String> searchParams, Pageable pageable){
        var booleanBuilder = new BooleanBuilder();
        buildSearch(searchParams, booleanBuilder);
        return empruntRepository.findAll(booleanBuilder, pageable)
                .map(empruntMapper::asDto);
    }

    private void buildSearch(Map<String, String> searchParams, BooleanBuilder booleanBuilder) {
        if (Objects.nonNull(searchParams)) {
            var qEntity = QEmpruntEntity.empruntEntity;

            if (searchParams.containsKey("dateEmprunt")){
                Date date = null;
                try {
                    date = new SimpleDateFormat("yyyy-MM-dd").parse(searchParams.get("dateEmprunt"));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                booleanBuilder.and(qEntity.dateEmprunt.eq(date));
            }

            if (searchParams.containsKey("dateRetour")){
                Date date = null;
                try {
                    date = new SimpleDateFormat("yyyy-MM-dd").parse(searchParams.get("dateRetour"));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                booleanBuilder.and(qEntity.dateRetour.eq(date));
            }
        }
    }
}
