package com.ryudnar.MusecaInfo.domain.Repository;

import com.ryudnar.MusecaInfo.domain.Entity.UserDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepository extends JpaRepository<UserDataEntity, Long> {

}
