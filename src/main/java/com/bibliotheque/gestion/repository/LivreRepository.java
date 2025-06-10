package com.bibliotheque.gestion.repository;

import com.bibliotheque.gestion.entity.LivreEntity;
import com.bibliotheque.gestion.model.EmployeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface LivreRepository extends JpaRepository<LivreEntity, Long>, QuerydslPredicateExecutor<LivreEntity> {
}
