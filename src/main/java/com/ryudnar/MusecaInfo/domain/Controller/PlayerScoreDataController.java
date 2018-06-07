package com.ryudnar.MusecaInfo.domain.Controller;

import com.ryudnar.MusecaInfo.domain.DTO.PlayerDataSaveRequestDto;
import com.ryudnar.MusecaInfo.domain.DTO.PlayerScoreDataSaveRequestDto;
import com.ryudnar.MusecaInfo.domain.Service.PlayerScoreDataService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/score")
public class PlayerScoreDataController {
  private PlayerScoreDataService playerScoreDataService;

  @GetMapping("/")
  public String main() {
    return "main";
  }

  @PostMapping("/save")
  public Long savePlayerScoreData(@RequestBody PlayerScoreDataSaveRequestDto playerScoreDataSaveRequestDto){
    return playerScoreDataService.save(playerScoreDataSaveRequestDto);
  }
}
