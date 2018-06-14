package com.ryudnar.MusecaInfo.domain.Service;

import com.ryudnar.MusecaInfo.domain.DTO.UserDataSaveRequestDto;
import com.ryudnar.MusecaInfo.domain.Repository.UserDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class UserDataService {
  @Autowired
  private UserDataRepository userDataRepository;

  @Transactional
  public Long save(UserDataSaveRequestDto userDataSaveRequestDto) {
    return userDataRepository.save(userDataSaveRequestDto.toEntity()).getId();
  }
}