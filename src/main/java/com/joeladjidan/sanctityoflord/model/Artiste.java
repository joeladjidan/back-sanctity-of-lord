package com.joeladjidan.sanctityoflord.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "sanctity_artiste")
public class Artiste extends AbstractEntity {

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

  @Column(name = "dateDeNaissance")
  private Date dateDeNaissance;

  @Column(name = "photo")
  private String photo;

  @ManyToOne
  @JoinColumn(name = "sanctity_adresse")
  private Adresse adresse;

}
