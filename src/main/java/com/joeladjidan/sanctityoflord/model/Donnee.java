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
@Table(name = "sanctity_donnee")
public class Donnee extends AbstractEntity {

  /**
	 *
	 */
	private static final long serialVersionUID = 1L;

  @Column(name = "fileName")
  private String fileName;

  @Column(name = "url")
  private String url;

  @Column(name = "date")
  private Date date;

  @Column(name = "size")
  private Long size;

  @Column(name = "format")
  private String format;


}
