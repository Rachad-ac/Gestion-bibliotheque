package com.bibliotheque.gestion.model;

import com.bibliotheque.gestion.entity.enums.SexeType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    @NotEmpty
    private String nom;
    private String prenom;
    private SexeType sexe;
    private String email;
    private String telephone;
    private String poste;
    private Double salaire;

    private BibliothequeDTO bibliotheque;

    private Long bibliothequeId;
}
