package com.joeladjidan.sanctityoflord.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "sanctity_adresse")
public class Adresse extends AbstractEntity {

  @Column(name = "adresse1")
  private String adresse1;

  @Column(name = "adresse2")
  private String adresse2;

  @ManyToOne
  @JoinColumn(name = "sanctity_code_postale")
  private CodePostale codePostale;

  @ManyToOne
  @JoinColumn(name = "sanctity_pays")
  private Pays pays;

  @ManyToOne
  @JoinColumn(name = "sanctity_ville")
  private Ville ville;


}
