package com.joeladjidan.sanctityoflord.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

  @Column(name = "motdepasse")
  private String moteDePasse;

  @ManyToOne
  @JoinColumn
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
