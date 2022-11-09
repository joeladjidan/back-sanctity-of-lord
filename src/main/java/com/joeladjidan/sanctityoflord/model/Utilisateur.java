package com.joeladjidan.sanctityoflord.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "sanctity_utilisateur")
public class Utilisateur extends AbstractEntity {

  /**
	 *
	 */
	private static final long serialVersionUID = 1L;

  @Column(name = "nom")
  private String nom;

  @Column(name = "prenom")
  private String prenom;

  @Column(name = "num_tel")
  private String numTel;

  @Column(name = "email")
  private String email;

  @Column(name = "dateDeNaissance")
  private Date dateDeNaissance;

  @Column(name = "motdepasse" , length = 1000)
  private String moteDePasse;

  @ManyToOne
  @JoinColumn(name = "idAdresse")
  private Adresse adresse;

  @Column(name = "photo")
  private String photo;

  @ManyToOne
  @JoinColumn(name = "identreprise")
  private Entreprise entreprise;

  @OneToMany(fetch = FetchType.EAGER)
  @JsonIgnore
  private List<Roles> roles;

}
