package com.joeladjidan.sanctityoflord.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Jacksonized //missing
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "sanctity_donnee")
public class Donnee extends AbstractEntity {

  /**
	 *
	 */
	private static final long serialVersionUID = 1L;

  @JsonProperty("fileName")
  @Column(name = "fileName")
  private String fileName;

  @JsonProperty("url")
  @Column(name = "url")
  private String url;

  @JsonProperty("date")
  @Column(name = "date")
  private Date date;

  @JsonProperty("format")
  @Column(name = "format")
  private String format;


}
