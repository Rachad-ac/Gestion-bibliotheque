package com.bibliotheque.gestion.services;

import com.bibliotheque.gestion.entity.EmployeEntity;
import com.bibliotheque.gestion.model.EmployeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Map;

public interface EmployeService {

    EmployeDTO createEmploye(EmployeDTO employeDTO);
    EmployeDTO updateEmploye(EmployeDTO employeDTO);
    EmployeDTO getEmploye(Long id);
    Page<EmployeEntity> findByBibliothequeId(Long id, Pageable pageable);
}
