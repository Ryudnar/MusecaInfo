package com.ryudnar.MusecaInfo.domain.Repository;

import com.ryudnar.MusecaInfo.domain.Entity.PlayerScoreDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerScoreDataRepository extends JpaRepository<PlayerScoreDataEntity, Long> {
}
