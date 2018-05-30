package com.ryudnar.MusecaInfo.domain.Service;

import com.ryudnar.MusecaInfo.domain.Entity.UserDataEntity;
import lombok.Data;

@Data
public class UserDataService {
  private String UserName;
  private String UserEmail;

  public UserDataEntity toEntity() {
      return UserDataEntity.builder()
              .UserName(UserName)
              .UserEmail(UserEmail)
              .build();
  }
}