package com.ryudnar.MusecaInfo.domain.DTO;

import com.ryudnar.MusecaInfo.domain.Entity.SongDataEntity;
import lombok.Data;

@Data
public class SongDataSaveRequestDto {
  private String name;
  private String artist;
  private String illustrator;
  private Integer green;
  private Integer yellow;
  private Integer red;

  public SongDataEntity toEntity() {
    return SongDataEntity.builder()
      .name(name)
      .artist(artist)
      .illustrator(illustrator)
      .green(green)
      .yellow(yellow)
      .red(red)
      .build();
  }
}
