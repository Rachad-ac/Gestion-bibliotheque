package com.bibliotheque.gestion.services;

import com.bibliotheque.gestion.model.AuteurDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface AuteurService {

    AuteurDTO createAuteur(AuteurDTO auteurDTO);
    AuteurDTO getAuteur(Long id);
    void deleteAuteur(Long id);
    AuteurDTO updateAuteur(AuteurDTO auteurDTO);
    Page<AuteurDTO> getAllAuteur(Map<String, String> searchParams, Pageable pageable);
}
