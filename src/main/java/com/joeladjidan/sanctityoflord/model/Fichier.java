package com.joeladjidan.sanctityoflord.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "sanctity_fichier")
public class Fichier extends AbstractEntity {

  /**
	 *
	 */
	private static final long serialVersionUID = 1L;

  @Column(name = "nom")
  private String nom;

}
