package com.bibliotheque.gestion.repository;

import com.bibliotheque.gestion.entity.AbonneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface AbonneRepository extends JpaRepository<AbonneEntity, Long>, QuerydslPredicateExecutor<AbonneEntity> {
}
