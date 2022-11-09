package com.joeladjidan.sanctityoflord.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "sanctity_galerie")
public class Galerie extends AbstractEntity {

  @Column(name = "intitule")
  private String intitule;

  @ManyToOne
  @JoinColumn(name = "idDonnee")
  private Donnee donnee;

}
