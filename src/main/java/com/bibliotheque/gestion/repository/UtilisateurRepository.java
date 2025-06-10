package com.bibliotheque.gestion.repository;

import com.bibliotheque.gestion.entity.UtilisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface UtilisateurRepository extends JpaRepository<UtilisateurEntity, Long>, QuerydslPredicateExecutor<UtilisateurEntity> {
}
