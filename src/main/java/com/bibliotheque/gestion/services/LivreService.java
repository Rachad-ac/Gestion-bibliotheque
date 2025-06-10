package com.bibliotheque.gestion.services;

import com.bibliotheque.gestion.entity.EmployeEntity;
import com.bibliotheque.gestion.entity.LivreEntity;
import com.bibliotheque.gestion.model.EmployeDTO;
import com.bibliotheque.gestion.model.LivreDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Map;

public interface LivreService {
    LivreDTO createLivre(LivreDTO livreDTO);
    LivreDTO updateLivre(LivreDTO livreDTO);
    void deleteLivre(Long id);
    LivreDTO getLivre(Long id);
    Page<LivreDTO> getAllLivre(Map<String, String> searchParams, Pageable pageable);
    Page<LivreDTO> getAllLivreBibliotheque(Map<String, String> searchParams, Pageable pageable, Long idBibliotheque);
    Page<LivreEntity> findByBibliothequeId(Long id, Pageable pageable);

}
