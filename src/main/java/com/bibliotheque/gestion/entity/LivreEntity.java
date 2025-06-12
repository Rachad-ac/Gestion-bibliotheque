package com.bibliotheque.gestion.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Table(name = "livres")
@AllArgsConstructor
@NoArgsConstructor
public class LivreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "titre")
    private String titre;
    @Column(name = "nom_auteur")
    private String nomAuteur;
    @Column(name = "disponibilite")
    private Boolean disponibilite = true;
    @Column(name = "nombre_pages")
    private Integer nbrPages;
    @Column(name = "priix")
    private double prix;
    @Column(name = "date_publication")
    private Date datePub;

    @ManyToOne
    @JoinColumn(name = "auteur_id")
    private AuteurEntity auteur;

    @ManyToOne
    @JoinColumn(name = "bibliotheque_id")
    private LibreryEntity bibliotheque;
}
