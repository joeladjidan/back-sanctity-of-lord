package com.joeladjidan.sanctityoflord.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "sanctity_emission")
public class Emission extends AbstractEntity {

  @Column(name = "description")
  private String description;

  @Column(name = "dateEmission", nullable = false, updatable = false)
  private Date dateEmission;

  @ManyToOne
  @JoinColumn(name = "idDonnee")
  private Donnee donnee;

  @ManyToOne
  @JoinColumn(name = "idTypeEmission")
  private TypeEmission typeEmission;

}


