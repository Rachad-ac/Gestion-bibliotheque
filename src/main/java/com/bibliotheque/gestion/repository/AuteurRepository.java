package com.bibliotheque.gestion.repository;

import com.bibliotheque.gestion.entity.AuteurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface AuteurRepository extends JpaRepository<AuteurEntity, Long>, QuerydslPredicateExecutor<AuteurEntity> {
}
