package com.ryudnar.MusecaInfo.domain.Entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Table(name = "player_data")
@Getter
@Entity
public class PlayerDataEntity extends BaseTimeEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true)
  private Long id;

  @Column(name = "player_name", length = 10, nullable = false)
  private String playerName;

  @Column(name = "player_rank", nullable = false)
  private int playerRank;

  @Column(name = "player_coloris", nullable = false)
  private int playerColoris;

  @Column(name = "player_grafica", nullable = false)
  private int playerGrafica;

  @Column(name = "player_latest_date", length = 20, nullable = false)
  private String playerLatestDate;

  @Column(name = "player_latest_place", length = 30, nullable = false)
  private String playerLatestPlace;

  @Column(name = "player_latest_count", nullable = false)
  private int playerLatestCount;

  @Builder
  public PlayerDataEntity(String playerName, int playerRank, int playerColoris, int playerGrafica, String playerLatestDate, String playerLatestPlace, int playerLatestCount) {
    this.playerName = playerName;
    this.playerRank = playerRank;
    this.playerColoris = playerColoris;
    this.playerGrafica = playerGrafica;
    this.playerLatestDate = playerLatestDate;
    this.playerLatestPlace = playerLatestPlace;
    this.playerLatestCount = playerLatestCount;
  }
}
