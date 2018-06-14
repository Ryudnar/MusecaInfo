package com.ryudnar.MusecaInfo.domain.DTO;

import com.ryudnar.MusecaInfo.domain.Entity.PlayerScoreDataEntity;
import com.ryudnar.MusecaInfo.domain.Entity.SongDataEntity;
import lombok.Data;

@Data
public class PlayerScoreDataAndSongDataSaveRequestDto {
  private Integer difficulty;
  private Integer level;
  private Integer score;
  private Integer playCount;
  private Integer caCount;
  private String title;
  private String artist;

  public PlayerScoreDataEntity toPlayerScoreDataEntity(int songId) {
    return PlayerScoreDataEntity.builder()
      .songId(songId)
      .difficulty(difficulty)
      .level(level)
      .score(score)
      .playCount(playCount)
      .caCount(caCount)
      .build();
  }

  public SongDataEntity toSongDataEntity() {
    return SongDataEntity.builder()
      .title(title)
      .artist(artist)
      .build();
  }
}
