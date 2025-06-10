package com.bibliotheque.gestion.repository;

import com.bibliotheque.gestion.entity.EmployeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface EmployeRepository extends JpaRepository<EmployeEntity, Long>, QuerydslPredicateExecutor<EmployeEntity> {
}
