package com.joeladjidan.sanctityoflord.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import javax.persistence.*;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @CreatedDate
  @Column(name = "creationDate", nullable = false, updatable = false)
  private Date creationDate;

  @LastModifiedDate
  @Column(name = "lastModifiedDate")
  private Date lastModifiedDate;


}
