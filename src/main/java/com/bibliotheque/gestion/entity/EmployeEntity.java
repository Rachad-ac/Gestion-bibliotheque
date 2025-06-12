package com.bibliotheque.gestion.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    @Column(name = "date_emboche")
    private Date dateEmboche;
}
