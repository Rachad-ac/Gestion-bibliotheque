package com.bibliotheque.gestion.services;

import com.bibliotheque.gestion.model.EmpruntDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Map;

public interface EmpruntService {
    EmpruntDTO createEmprunt(EmpruntDTO empruntDTO);
    EmpruntDTO getEmprunt(Long id);
    void deleteEmprunt(Long id);
    EmpruntDTO updateEmprunt(EmpruntDTO empruntDTO);
    Page<EmpruntDTO> getAllEmprunt(Map<String, String> searchParams, Pageable pageable);
}
