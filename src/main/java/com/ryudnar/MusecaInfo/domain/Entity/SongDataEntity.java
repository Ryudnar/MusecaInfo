package com.ryudnar.MusecaInfo.domain.Entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Table(name = "song_data")
@Getter
@Entity
public class SongDataEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true)
  private Integer id;

  @Column(name = "name", length = 100, nullable = false)
  private String name;

  @Column(name = "artist", length = 50, nullable = false)
  private String artist;

  @Column(name = "illustrator", length = 50, nullable = false)
  private String illustrator;

  @Column(name = "difficulty_green", nullable = false)
  private Integer green;

  @Column(name = "difficulty_yellow", nullable = false)
  private Integer yellow;

  @Column(name = "difficulty_red", nullable = false)
  private Integer red;

  @Builder
  private SongDataEntity(String name, String artist, String illustrator, Integer green, Integer yellow, Integer red) {
    this.name = name;
    this.artist = artist;
    this.illustrator = illustrator;
    this.green = green;
    this.yellow = yellow;
    this.red = red;
  }
}
