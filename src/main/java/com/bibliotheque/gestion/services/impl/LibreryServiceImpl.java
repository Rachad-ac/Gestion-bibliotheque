package com.bibliotheque.gestion.services.impl;

import com.bibliotheque.gestion.entity.QLibreryEntity;
import com.bibliotheque.gestion.mapper.LibreryMapper;
import com.bibliotheque.gestion.model.LibreryDTO;
import com.bibliotheque.gestion.repository.LibreryRepository;
import com.bibliotheque.gestion.services.LibreryService;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Map;
import java.util.Objects;

@Transactional
@RequiredArgsConstructor
@Service
public class LibreryServiceImpl implements LibreryService {

    private final LibreryRepository libreryRepository;
    private final LibreryMapper libreryMapper;

    @Override
    public LibreryDTO createLibrery(LibreryDTO libreryDTO){
        var entity = libreryMapper.asEntity(libreryDTO);
        var entitySave = libreryRepository.save(entity);
        return libreryMapper.asDto(entitySave);
    }

    @Override
    public LibreryDTO getLibrery(Long id){
        var entity = libreryRepository.findById(id);
        return libreryMapper.asDto(entity.get());
    }

    @Override
    public void deleteLibrery(Long id){
        if(!libreryRepository.existsById(id)){
            throw new RuntimeException("Librery non trouver !") ;
        }
        libreryRepository.deleteById(id);
    }

    @Override
    public LibreryDTO updateLibrery(LibreryDTO libreryDTO){
        var entity = libreryMapper.asEntity(libreryDTO);
        var entityUpdate = libreryRepository.save(entity);
        return libreryMapper.asDto(entityUpdate);
    }

    @Override
    public Page<LibreryDTO> getAllLibrery(Map<String, String> searchParams, Pageable pageable) {
        var booleanBuilder = new BooleanBuilder();
        buildSearch(searchParams, booleanBuilder);
        return libreryRepository.findAll(booleanBuilder, pageable)
                .map(libreryMapper::asDto);
    }

    private void buildSearch(Map<String, String> searchParams, BooleanBuilder booleanBuilder) {
        if (Objects.nonNull(searchParams)) {
            var qEntity = QLibreryEntity.libreryEntity;

            if (searchParams.containsKey("nom"))
                booleanBuilder.and(qEntity.nom.containsIgnoreCase(searchParams.get("nom")));

            if (searchParams.containsKey("ville"))
                booleanBuilder.and(qEntity.ville.containsIgnoreCase(searchParams.get("ville")));

            if (searchParams.containsKey("adresse"))
                booleanBuilder.and(qEntity.adresse.containsIgnoreCase(searchParams.get("adresse")));

            if (searchParams.containsKey("email"))
                booleanBuilder.and(qEntity.email.containsIgnoreCase(searchParams.get("email")));

        }
    }
}