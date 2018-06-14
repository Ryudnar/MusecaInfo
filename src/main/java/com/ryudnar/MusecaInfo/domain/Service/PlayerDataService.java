package com.ryudnar.MusecaInfo.domain.Service;

import com.ryudnar.MusecaInfo.domain.DTO.PlayerDataSaveRequestDto;
import com.ryudnar.MusecaInfo.domain.Repository.PlayerDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class PlayerDataService {
  @Autowired
  private PlayerDataRepository playerDataRepository;

  @Transactional
  public long save(PlayerDataSaveRequestDto playerDataSaveRequestDto) {
    return playerDataRepository.save(playerDataSaveRequestDto.toEntity()).getId();
  }
}
