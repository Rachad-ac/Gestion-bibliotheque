package com.bibliotheque.gestion.entity;

import com.bibliotheque.gestion.entity.enums.NationaliteType;
import com.bibliotheque.gestion.entity.enums.SexeType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Table(name = "auteurs")
@AllArgsConstructor
@NoArgsConstructor
public class AuteurEntity {

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
    @Column(name = "date_naiss")
    private Date dateNaiss;
    @Enumerated(EnumType.STRING)
    @Column(name = "nationalite")
    private NationaliteType nationalite;


}
