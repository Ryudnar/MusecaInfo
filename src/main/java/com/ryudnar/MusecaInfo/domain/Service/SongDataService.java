package com.ryudnar.MusecaInfo.domain.Service;

import com.ryudnar.MusecaInfo.domain.Entity.SongDataEntity;
import com.ryudnar.MusecaInfo.domain.Repository.SongDataRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SongDataService {
  @Autowired
  private SongDataRepository songDataRepository;

  @Getter
  private List<SongDataEntity> songDataEntityList;
  @Getter
  private Map<String, Integer> songTitleIdMap;

  @PostConstruct
  public void init() {
    songDataEntityList = songDataRepository.findAll();
    songTitleIdMap = songDataEntityList.stream()
                                        .collect(Collectors.toMap(i -> i.getTitle(), i -> i.getId()));
  }

  @Transactional
  public void reload() {
    songDataEntityList = songDataRepository.findAll();
    songTitleIdMap = songDataEntityList.stream()
      .collect(Collectors.toMap(i -> i.getTitle(), i -> i.getId()));
  }

  @Transactional
  public Integer saveAll(List<SongDataEntity> songDataEntity) {
    return songDataRepository.saveAll(songDataEntity).size();
  }

  public Integer getSongIdByTitle(String title) {
    return songTitleIdMap.get(title);
  }

  public Integer getSongCount() {
    return songDataEntityList.size();
  }

  public boolean containsSongData(String title) {
    return songTitleIdMap.containsKey(title);
  }
}
