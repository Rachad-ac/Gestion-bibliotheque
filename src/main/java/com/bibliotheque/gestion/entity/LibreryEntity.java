package com.bibliotheque.gestion.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "librery")
@AllArgsConstructor
@NoArgsConstructor
public class LibreryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom_biblio")
    private String nom;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "ville")
    private String ville;
    @Column(name = "email" , unique = true)
    private  String email;
    @Column(name = "telephone")
    private String tel;

}
