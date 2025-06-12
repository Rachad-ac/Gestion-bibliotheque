package com.bibliotheque.gestion.services;

import com.bibliotheque.gestion.model.EmployeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Map;

public interface EmployeService {

    EmployeDTO createEmploye(EmployeDTO employeDTO);
    EmployeDTO getEmploye(Long id);
    void deleteEmploye(Long id);
    EmployeDTO updateEmploye(EmployeDTO employeDTO);
    Page<EmployeDTO> getAllEmploye(Map<String, String> searchParams, Pageable pageable);

}
