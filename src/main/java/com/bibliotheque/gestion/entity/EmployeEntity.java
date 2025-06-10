package com.bibliotheque.gestion.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "employes")
@AllArgsConstructor
@NoArgsConstructor
public class EmployeEntity extends PersonneEntity{

    @Column(name = "poste")
    private String poste;
    @Column(name = "salaire")
    private Double salaire;

    @ManyToOne
    @JoinColumn(name = "bibliotheque_id")
    private BibliothequeEntity bibliotheque;
}
