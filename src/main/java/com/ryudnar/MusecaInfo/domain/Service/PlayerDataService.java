package com.ryudnar.MusecaInfo.domain.Service;

import com.ryudnar.MusecaInfo.domain.DTO.PlayerDataSaveRequestDto;
import com.ryudnar.MusecaInfo.domain.DTO.UserDataSaveRequestDto;
import com.ryudnar.MusecaInfo.domain.Repository.PlayerDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class PlayerDataService {
  private PlayerDataRepository playerDataRepository;

  @Transactional
  public Long save(PlayerDataSaveRequestDto playerDataSaveRequestDto) {
    return playerDataRepository.save(playerDataSaveRequestDto.toEntity()).getId();
  }
}
