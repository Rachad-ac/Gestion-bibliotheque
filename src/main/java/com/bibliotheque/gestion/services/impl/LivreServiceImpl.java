package com.bibliotheque.gestion.services.impl;

import com.bibliotheque.gestion.entity.QLivreEntity;
import com.bibliotheque.gestion.mapper.LivreMapper;
import com.bibliotheque.gestion.model.LivreDTO;
import com.bibliotheque.gestion.repository.LivreRepository;
import com.bibliotheque.gestion.services.LivreService;
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
public class LivreServiceImpl implements LivreService {

    private final LivreRepository livreRepository;
    private final LivreMapper livreMapper;

    @Override
    public LivreDTO createLivre(LivreDTO livreDTO){
        var entity = livreMapper.asEntity(livreDTO);
        var entitySave = livreRepository.save(entity);
        return livreMapper.asDto(entitySave);
    }

    @Override
    public LivreDTO updateLivre(LivreDTO livreDTO){
        var entity = livreMapper.asEntity(livreDTO);
        var entityUpdate = livreRepository.save(entity);
        return livreMapper.asDto(entityUpdate);
    }

    @Override
    public void deleteLivre(Long id){
        if(!livreRepository.existsById(id)){
            throw new RuntimeException("livre non trouver");
        }
        livreRepository.deleteById(id);
    }

    @Override
    public LivreDTO getLivre(Long id){
        var entity = livreRepository.findById(id);
        return livreMapper.asDto(entity.get());
    }

    @Override
    public Page<LivreDTO> getAllLivre(Map<String, String> searchParams, Pageable pageable){
        var booleanBuilder = new BooleanBuilder();
        buildSearch(searchParams, booleanBuilder);
        return livreRepository.findAll(booleanBuilder, pageable)
                .map(livreMapper::asDto);
    }


    private void buildSearch(Map<String, String> searchParams, BooleanBuilder booleanBuilder) {
        if (Objects.nonNull(searchParams)) {
            var qEntity = QLivreEntity.livreEntity;

            if (searchParams.containsKey("titre"))
                booleanBuilder.and(qEntity.titre.containsIgnoreCase(searchParams.get("titre")));

            if (searchParams.containsKey("nomAuteur"))
                booleanBuilder.and(qEntity.nomAuteur.containsIgnoreCase(searchParams.get("nomAuteur")));

            if (searchParams.containsKey("salaire")) {
                try {
                    double montant = Double.parseDouble(searchParams.get("prix"));
                    booleanBuilder.and(qEntity.prix.eq(montant));
                } catch (NumberFormatException e) {
                    throw new RuntimeException("Le montant net doit être un nombre valide", e);
                }
            }

            if (searchParams.containsKey("datePub")){
                Date date = null;
                try {
                    date = new SimpleDateFormat("yyyy-MM-dd").parse(searchParams.get("datePub"));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                booleanBuilder.and(qEntity.datePub.eq(date));
            }

        }
    }
}
