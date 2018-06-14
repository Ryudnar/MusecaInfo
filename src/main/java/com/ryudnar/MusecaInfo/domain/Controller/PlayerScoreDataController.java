package com.ryudnar.MusecaInfo.domain.Controller;

import com.ryudnar.MusecaInfo.domain.DTO.PlayerScoreDataAndSongDataSaveRequestDto;
import com.ryudnar.MusecaInfo.domain.Entity.SongDataEntity;
import com.ryudnar.MusecaInfo.domain.Service.PlayerScoreDataService;
import com.ryudnar.MusecaInfo.domain.Service.SongDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/score")
public class PlayerScoreDataController {
  @Autowired
  private PlayerScoreDataService playerScoreDataService;

  @Autowired
  private SongDataService songDataService;

  @GetMapping("/")
  public String main() {
    return "score/main";
  }

  @CrossOrigin
  @ResponseStatus(value = HttpStatus.OK)
  @PostMapping("/save")
  public void savePlayerScoreData(@RequestBody List<PlayerScoreDataAndSongDataSaveRequestDto> playerScoreDataAndSongDataSaveRequestDto){
    if(playerScoreDataAndSongDataSaveRequestDto.size() > songDataService.getSongCount() * 3) {
      List<SongDataEntity> updatedSong = playerScoreDataAndSongDataSaveRequestDto.stream()
        .filter(dto -> !songDataService.containsSongData(dto.getTitle()))
        .filter(dto -> dto.getDifficulty() == 3)
        .map(dto -> dto.toSongDataEntity())
        .collect(Collectors.toList());

      songDataService.saveAll(updatedSong);
      songDataService.reload();
    }

    playerScoreDataService.saveAll(playerScoreDataAndSongDataSaveRequestDto.stream()
                                                                        .map(dto -> dto.toPlayerScoreDataEntity(songDataService.getSongIdByTitle(dto.getTitle())))
                                                                        .collect(Collectors.toList()));
  }
}
