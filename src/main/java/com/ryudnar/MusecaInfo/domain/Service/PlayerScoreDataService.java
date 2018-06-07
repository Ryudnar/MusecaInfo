package com.ryudnar.MusecaInfo.domain.Service;

import com.ryudnar.MusecaInfo.domain.DTO.PlayerScoreDataSaveRequestDto;
import com.ryudnar.MusecaInfo.domain.Entity.PlayerScoreDataEntity;
import com.ryudnar.MusecaInfo.domain.Repository.PlayerScoreDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
public class PlayerScoreDataService {
  private PlayerScoreDataRepository playerScoreDataRepository;

  @Transactional
  public Long save(PlayerScoreDataSaveRequestDto playerScoreDataSaveRequestDto) {
    return playerScoreDataRepository.save(playerScoreDataSaveRequestDto.toEntity()).getId();
  }

  @Transactional
  public List<PlayerScoreDataEntity> getAll() {
    // TODO: player_score_data table에서 player_id로 모든 데이터 긁어오기 구현, 이때 player_id 검증은 어떻게 할 것인지 고민 필요.
  }
}
