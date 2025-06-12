package com.bibliotheque.gestion.repository;

import com.bibliotheque.gestion.entity.LibreryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface LibreryRepository extends JpaRepository<LibreryEntity, Long>, QuerydslPredicateExecutor<LibreryEntity> {
}
