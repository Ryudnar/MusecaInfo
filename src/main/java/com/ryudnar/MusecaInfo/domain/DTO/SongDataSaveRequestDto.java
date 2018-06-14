package com.ryudnar.MusecaInfo.domain.DTO;

import com.ryudnar.MusecaInfo.domain.Entity.SongDataEntity;
import lombok.Data;

@Data
public class SongDataSaveRequestDto {
  private String title;
  private String artist;

  public SongDataEntity toEntity() {
    return SongDataEntity.builder()
      .title(title)
      .artist(artist)
      .build();
  }
}
