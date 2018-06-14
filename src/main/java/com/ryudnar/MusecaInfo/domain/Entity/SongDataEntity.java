package com.ryudnar.MusecaInfo.domain.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Table(name = "song_data")
@Getter
@Entity
@ToString
public class SongDataEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true)
  private Integer id;

  @Column(name = "title", length = 100, nullable = false)
  private String title;

  @Column(name = "artist", length = 50, nullable = false)
  private String artist;

  @Builder
  private SongDataEntity(String title, String artist) {
    this.title = title;
    this.artist = artist;
  }
}
