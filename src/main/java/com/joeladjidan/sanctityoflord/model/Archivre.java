package com.joeladjidan.sanctityoflord.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "sanctity_archivre")
public class Archivre extends AbstractEntity {

  /**
	 *
	 */
	private static final long serialVersionUID = 1L;

  @Column(name = "date", nullable = false, updatable = false)
  private Date dateArchivre;

  @ManyToOne
  @JoinColumn(name = "sanctity_emission")
  private Emission emission;


  @ManyToOne
  @JoinColumn(name = "sanctity_enseignement")
  private Enseignement enseignement;


}
