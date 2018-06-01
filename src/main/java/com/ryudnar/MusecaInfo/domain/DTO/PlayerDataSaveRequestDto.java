package com.ryudnar.MusecaInfo.domain.DTO;

import com.ryudnar.MusecaInfo.domain.Entity.PlayerDataEntity;
import lombok.Data;

import java.util.Date;

@Data
public class PlayerDataSaveRequestDto {
  private String playerName;
  private int playerRank;
  private int playerColoris;
  private int playerGrafica;
  private String playerLatestDate;
  private String playerLatestPlace;
  private int playerLatestCount;

  public PlayerDataEntity toEntity() {
    return PlayerDataEntity.builder()
      .playerName(playerName)
      .playerRank(playerRank)
      .playerColoris(playerColoris)
      .playerGrafica(playerGrafica)
      .playerLatestDate(playerLatestDate)
      .playerLatestPlace(playerLatestPlace)
      .playerLatestCount(playerLatestCount)
      .build();
  }
}
