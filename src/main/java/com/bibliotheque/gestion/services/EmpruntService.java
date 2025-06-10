package com.bibliotheque.gestion.services;

import com.bibliotheque.gestion.model.EmpruntDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Map;

public interface EmpruntService {
    EmpruntDTO createEmprunt(EmpruntDTO empruntDTO);
    EmpruntDTO updateEmprunt(EmpruntDTO empruntDTO);
    void deleteEmprunt(Long id);
    void rendreEmprunt(Long id);
    EmpruntDTO getEmprunt(Long id);
    Page<EmpruntDTO> getAllEmprunt(Map<String, String> searchParams, Pageable pageable);
    Page<EmpruntDTO> getAllEmpruntBibliotheque(Map<String, String> searchParams, Pageable pageable, Long idBibliotheque);

}
