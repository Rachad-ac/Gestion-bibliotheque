package com.bibliotheque.gestion.services.impl;

import com.bibliotheque.gestion.mapper.BibliothequeMapper;
import com.bibliotheque.gestion.mapper.EmployeMapper;
import com.bibliotheque.gestion.mapper.LivreMapper;
import com.bibliotheque.gestion.model.BibliothequeDTO;
import com.bibliotheque.gestion.entity.QBibliothequeEntity;
import com.bibliotheque.gestion.model.EmployeDTO;
import com.bibliotheque.gestion.model.LivreDTO;
import com.bibliotheque.gestion.repository.BibliothequeRepository;
import com.bibliotheque.gestion.services.BibliothequeService;
import com.bibliotheque.gestion.services.EmployeService;
import com.bibliotheque.gestion.services.LivreService;
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
public class BibliothequeServiceImpl  {
/*
    private final BibliothequeRepository bibliothequeRepository;
    private final BibliothequeMapper bibliothequeMapper;
    private final EmployeService employeService;
    private final EmployeMapper employeMapper;
    private final LivreService livreService;
    private final LivreMapper livreMapper;

    @Override
    public BibliothequeDTO createBibliotheque(BibliothequeDTO bibliothequeDTO){
        var entity = bibliothequeMapper.asEntity(bibliothequeDTO);
        var entitySave = bibliothequeRepository.save(entity);
        return bibliothequeMapper.asDto(entitySave);
    }

    @Override
    public BibliothequeDTO getBibliotheque(Long id){
        var entity = bibliothequeRepository.findById(id);
        return bibliothequeMapper.asDto(entity.get());
    }

    @Override
    public void deleteBibliotheque(Long id){
        if(!bibliothequeRepository.existsById(id)){
            throw new RuntimeException("Biblitheque non trouver !") ;
        }
        bibliothequeRepository.deleteById(id);
    }

    @Override
    public BibliothequeDTO updateBibliotheque(BibliothequeDTO bibliothequeDTO){
        var entity = bibliothequeMapper.asEntity(bibliothequeDTO);
        var entityUpdate = bibliothequeRepository.save(entity);
        return bibliothequeMapper.asDto(entityUpdate);
    }

    @Override
    public Page<EmployeDTO> getEmployes(Long id, Pageable pageable) {
        var employe = employeService.findByBibliothequeId(id, pageable);
        return employe.map(employeMapper::asDto);
    }

    @Override
    public Page<LivreDTO> getLivres(Long id, Pageable pageable) {
        var livre = livreService.findByBibliothequeId(id, pageable);
        return livre.map(livreMapper::asDto);
    }

    @Override
    public Page<BibliothequeDTO> getAllBibliotheque(Map<String, String> searchParams, Pageable pageable){
        var booleanBuilder = new BooleanBuilder();
        buildSearch(searchParams, booleanBuilder);
        return bibliothequeRepository.findAll(booleanBuilder, pageable)
                .map(bibliothequeMapper::asDto);
    }

    private void buildSearch(Map<String, String> searchParams, BooleanBuilder booleanBuilder) {
        if (Objects.nonNull(searchParams)) {
            var qEntity = QBibliothequeEntity.bibliothequeEntity;

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
*/

}