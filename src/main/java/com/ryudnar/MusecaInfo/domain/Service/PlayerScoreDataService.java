package com.ryudnar.MusecaInfo.domain.Service;

import com.ryudnar.MusecaInfo.domain.Entity.PlayerScoreDataEntity;
import com.ryudnar.MusecaInfo.domain.Repository.PlayerScoreDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlayerScoreDataService {
  @Autowired
  private PlayerScoreDataRepository playerScoreDataRepository;

  @Transactional
  public int saveAll(List<PlayerScoreDataEntity> playerScoreDataEntities) {
    return playerScoreDataRepository.saveAll(playerScoreDataEntities).size();
  }

//  @Transactional
//  public List<PlayerScoreDataEntity> getAll() {
//    // TODO: player_score_data table에서 player_id로 모든 데이터 긁어오기 구현, 이때 player_id 검증은 어떻게 할 것인지 고민 필요.
//  }
}
