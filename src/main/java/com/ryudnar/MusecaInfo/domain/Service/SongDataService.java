package com.ryudnar.MusecaInfo.domain.Service;

import com.ryudnar.MusecaInfo.domain.DTO.SongDataSaveRequestDto;
import com.ryudnar.MusecaInfo.domain.Entity.SongDataEntity;
import com.ryudnar.MusecaInfo.domain.Repository.SongDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
public class SongDataService {
  private SongDataRepository songDataRepository;

  @Transactional
  public Integer save(SongDataSaveRequestDto songDataSaveRequestDto) {
    return songDataRepository.save(songDataSaveRequestDto.toEntity()).getId();
  }

  // 노래 정보 가져오기, 스코어 상세 페이지에서 보여줄 때 쓰면 되려나?
  // 얘는 bean으로 해서 서버 켜져있는 동안 계속 들고 있는 편이 나을 것 같은데.
  @Transactional
  public List<SongDataEntity> getAll() {
    return songDataRepository.findAll();
  }
}
