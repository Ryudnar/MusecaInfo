package com.ryudnar.MusecaInfo.domain.Entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Table(name = "player_score_data")
@Getter
@Entity
public class PlayerScoreDataEntity extends BaseTimeEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true)
  private Long id;

  @Column(name = "song_id", nullable = false)
  private Long songId;

  @Column(name = "difficulty", nullable = false)
  private Integer difficulty;

  @Column(name = "score", nullable = false)
  private Integer score;

  @Column(name = "play_count", nullable = false)
  private Integer playCount;

  @Column(name = "ca_count", nullable = false)
  private Integer caCount;

  @Builder
  public PlayerScoreDataEntity(Long songId, Integer difficulty, Integer score, Integer playCount, Integer caCount) {
    this.songId = songId;
    this.difficulty = difficulty;
    this.score = score;
    this.playCount = playCount;
    this.caCount = caCount;
  }
}
