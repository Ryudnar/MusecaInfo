package com.ryudnar.MusecaInfo.domain.DTO;

import com.ryudnar.MusecaInfo.domain.Entity.UserDataEntity;
import lombok.Data;

@Data
public class UserDataSaveRequestDto {
  private String UserName;
  private String UserEmail;

  public UserDataEntity toEntity() {
    return UserDataEntity.builder()
      .UserName(UserName)
      .UserEmail(UserEmail)
      .build();
  }
}
