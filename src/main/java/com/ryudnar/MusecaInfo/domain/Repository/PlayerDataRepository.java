package com.ryudnar.MusecaInfo.domain.Repository;

import com.ryudnar.MusecaInfo.domain.Entity.PlayerDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerDataRepository extends JpaRepository<PlayerDataEntity, Long> {
}
