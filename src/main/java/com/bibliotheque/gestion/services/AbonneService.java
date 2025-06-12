package com.bibliotheque.gestion.services;

import com.bibliotheque.gestion.model.AbonneDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Map;

public interface AbonneService {
    AbonneDTO createAbonne(AbonneDTO abonneDTO);
    AbonneDTO updateAbonne(AbonneDTO abonneDTO);
    void deleteAbonne(Long id);
    AbonneDTO getAbonne(Long id);
    Page<AbonneDTO> getAllAbonne(Map<String, String> searchParams, Pageable pageable);

}
