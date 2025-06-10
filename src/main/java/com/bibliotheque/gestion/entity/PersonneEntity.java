package com.bibliotheque.gestion.entity;

import com.bibliotheque.gestion.entity.enums.SexeType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class PersonneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Enumerated(EnumType.STRING)
    @Column(name = "sexe")
    private SexeType sexe;
    @Column(name = "email" , unique = true)
    private String email;
    @Column(name = "telephone" , unique = true)
    private String telephone;
}
