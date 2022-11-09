package com.joeladjidan.sanctityoflord.services;

import com.joeladjidan.sanctityoflord.dto.TitreMessageDto;

import java.util.List;

public interface TitreMessageService {

  TitreMessageDto save(TitreMessageDto dto);

  TitreMessageDto findById(Integer id);

  List<TitreMessageDto> findAll();

  void delete(Integer id);
}
