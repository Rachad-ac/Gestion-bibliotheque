package com.bibliotheque.gestion.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Table(name = "abonnes")
@AllArgsConstructor
@NoArgsConstructor
public class AbonneEntity extends  PersonneEntity{

    @Column(name = "date_inscription")
    private Date dateInscri;

}
