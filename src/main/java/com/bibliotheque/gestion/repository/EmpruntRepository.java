package com.bibliotheque.gestion.repository;

import com.bibliotheque.gestion.entity.EmpruntEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface EmpruntRepository extends JpaRepository<EmpruntEntity, Long>, QuerydslPredicateExecutor<EmpruntEntity> {
}
