package com.bibliotheque.gestion.services;

import com.bibliotheque.gestion.model.UtilisateurDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Map;

public interface UtilisateurService {
    UtilisateurDTO createUtilisateur(UtilisateurDTO utilisateurDTO);
    UtilisateurDTO updateUtilisateur(UtilisateurDTO utilisateurDTO);
    void deleteUtilisateur(Long id);
    UtilisateurDTO getUtilisateur(Long id);
    Page<UtilisateurDTO> getAllUtilisateur(Map<String, String> searchParams, Pageable pageable);
    Page<UtilisateurDTO> getAllUtilisateurBibliotheque(Map<String, String> searchParams, Pageable pageable, Long idBibliotheque);

}
