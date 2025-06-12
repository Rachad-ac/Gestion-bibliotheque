package com.bibliotheque.gestion.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Data
@Table(name = "emprunts")
@AllArgsConstructor
@NoArgsConstructor
public class EmpruntEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date_emprunt")
    private Date dateEmprunt;
    @Column(name = "date_retour")
    private Date dateRetour;
    @Column(name = "est_rendu")
    private boolean estRendu;

    @ManyToOne
    @JoinColumn(name = "livre_id")
    private LivreEntity livre;

    @ManyToOne
    @JoinColumn(name = "abonne_id")
    private AbonneEntity abonne;

    @ManyToOne
    @JoinColumn(name = "employe_id")
    private EmployeEntity employe;
}
