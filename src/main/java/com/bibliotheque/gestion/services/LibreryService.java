package com.bibliotheque.gestion.services;

import com.bibliotheque.gestion.model.LibreryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Map;

public interface LibreryService {

    LibreryDTO createLibrery(LibreryDTO libreryDTO);
    LibreryDTO getLibrery(Long id);
    void deleteLibrery(Long id);
    LibreryDTO updateLibrery(LibreryDTO libreryDTO);
    Page<LibreryDTO> getAllLibrery(Map<String, String> searchParams, Pageable pageable);
}
