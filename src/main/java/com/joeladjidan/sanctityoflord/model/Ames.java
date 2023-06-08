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
@Table(name = "sanctity_ames")
public class Ames extends AbstractEntity {

  /**
	 *
	 */
	private static final long serialVersionUID = 1L;

  @Column(name = "nom")
  private String nom;

  @Column(name = "prenom")
  private String prenom;

  @Column(name = "email")
  private String email;

  @Column(name = "photo")
  private String photo;

  @Column(name = "telephone")
  private String telephone;

  @Column(name = "sujet")
  private String sujet;

  @Column(name = "localisation")
  private String localisation;

  @ManyToOne
  @JoinColumn(name = "idCivilite")
  private Civilite civilite;

  @ManyToOne
  @JoinColumn(name = "idCodePostale")
  private CodePostale codePostale;

  @ManyToOne
  @JoinColumn(name = "idVille")
  private Ville ville;

  @ManyToOne
  @JoinColumn(name = "idPays")
  private Pays pays;
}
