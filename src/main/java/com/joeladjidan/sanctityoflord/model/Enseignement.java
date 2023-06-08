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
@Table(name = "sanctity_enseignement")
public class Enseignement extends AbstractEntity {

  /**
	 *
	 */
	private static final long serialVersionUID = 1L;

  @Column(name = "description")
  private String description;

  @Column(name = "is_youtube")
  private boolean isYoutube;

  @ManyToOne
  @JoinColumn(name = "sanctity_donnee")
  private Donnee donnee;

  @ManyToOne
  @JoinColumn(name = "sanctity_type_emission")
  private TypeEmission typeEmission;

  @ManyToOne
  @JoinColumn(name = "sanctity_type_message")
  private TitreMessage titreMessage;

  @ManyToOne
  @JoinColumn(name = "sanctity_type_enseignement")
  private TypeEnseignement typeEnseignement;

}
