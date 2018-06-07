package com.ryudnar.MusecaInfo.domain.Repository;

import com.ryudnar.MusecaInfo.domain.Entity.SongDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongDataRepository extends JpaRepository<SongDataEntity, Integer> {

}
