package com.ryudnar.MusecaInfo.domain.Controller;

import com.ryudnar.MusecaInfo.domain.DTO.PlayerScoreDataSaveRequestDto;
import com.ryudnar.MusecaInfo.domain.Service.PlayerScoreDataService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/score")
public class PlayerScoreDataController {
  private PlayerScoreDataService playerScoreDataService;

  @GetMapping("/")
  public String main() {
    return "score/main";
  }

  @PostMapping("/save")
  public int savePlayerScoreData(@RequestBody List<PlayerScoreDataSaveRequestDto> playerScoreDataSaveRequestDto){
    return playerScoreDataService.saveAll(playerScoreDataSaveRequestDto);
  }
}
