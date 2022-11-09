package com.joeladjidan.sanctityoflord.model;

import java.util.List;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "sanctity_entreprise")
public class Entreprise extends AbstractEntity {

  @Column(name = "nom")
  private String nom;

  @Column(name = "description")
  private String description;

  @ManyToOne
  @JoinColumn(name = "sanctity_adresse")
  private Adresse adresse;

  @Column(name = "codefiscal")
  private String codeFiscal;

  @Column(name = "photo")
  private String photo;

  @Column(name = "email")
  private String email;

  @Column(name = "numtel")
  private String numTel;

  @Column(name = "siteweb")
  private String steWeb;

  @OneToMany(mappedBy = "entreprise")
  private List<Utilisateur> utilisateurs;

}
