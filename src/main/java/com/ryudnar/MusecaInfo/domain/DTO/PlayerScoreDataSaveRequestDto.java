package com.ryudnar.MusecaInfo.domain.DTO;

import com.ryudnar.MusecaInfo.domain.Entity.PlayerScoreDataEntity;
import lombok.Data;

@Data
public class PlayerScoreDataSaveRequestDto {
  private Integer songId;
  private Integer difficulty;
  private Integer level;
  private Integer score;
  private Integer playCount;
  private Integer caCount;

  public PlayerScoreDataEntity toEntity() {
    return PlayerScoreDataEntity.builder()
      .songId(songId)
      .difficulty(difficulty)
      .level(level)
      .score(score)
      .playCount(playCount)
      .caCount(caCount)
      .build();
  }
}
