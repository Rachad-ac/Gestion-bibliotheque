package com.bibliotheque.gestion.services;

import com.bibliotheque.gestion.model.BibliothequeDTO;
import com.bibliotheque.gestion.model.EmployeDTO;
import com.bibliotheque.gestion.model.LivreDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Map;

public interface BibliothequeService {

    BibliothequeDTO createBibliotheque(BibliothequeDTO bibliothequeDTO);
    BibliothequeDTO getBibliotheque(Long id);
    void deleteBibliotheque(Long id);
    BibliothequeDTO updateBibliotheque(BibliothequeDTO bibliothequeDTO);
    Page<EmployeDTO> getEmployes(Long id, Pageable pageable);
    Page<LivreDTO> getLivres(Long id, Pageable pageable);
    Page<BibliothequeDTO> getAllBibliotheque(Map<String, String> searchParams, Pageable pageable);
}
