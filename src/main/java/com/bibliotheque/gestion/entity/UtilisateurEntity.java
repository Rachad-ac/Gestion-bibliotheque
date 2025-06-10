package com.bibliotheque.gestion.entity;

import com.bibliotheque.gestion.entity.enums.SexeType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "utilisateurs")
@AllArgsConstructor
@NoArgsConstructor
public class UtilisateurEntity extends  PersonneEntity{

    @Column(name = "date_inscription")
    private String dateInscri;

}
