package com.bibliotheque.gestion.repository;

import com.bibliotheque.gestion.entity.BibliothequeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BibliothequeRepository extends JpaRepository<BibliothequeEntity, Long>, QuerydslPredicateExecutor<BibliothequeEntity> {
}
