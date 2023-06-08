package com.joeladjidan.sanctityoflord.dto;

import com.joeladjidan.sanctityoflord.model.Contact;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized //missing
public class ContactDto {

  private Integer id;
  private String nom;
  private String prenom;
  private String email;
  private String message;
  private String telephone;

  public static ContactDto fromEntity(Contact contact) {
    if (contact == null) {
        return null;
    }

    return ContactDto.builder()
        .id(contact.getId())
        .nom(contact.getNom())
        .email(contact.getEmail())
        .prenom(contact.getPrenom())
        .telephone(contact.getTelephone())
        .message(contact.getMessage())
        .build();
  }

  public static Contact toEntity(ContactDto dto) {
    if (dto == null) {
        return null;
    }
    Contact contact = new Contact();
    contact.setId(dto.getId());
    contact.setNom(dto.getNom());
    contact.setTelephone(dto.getTelephone());
    contact.setEmail(dto.getEmail());
    contact.setPrenom(dto.getPrenom());
    contact.setMessage(dto.getMessage());
    return contact;
  }

}
