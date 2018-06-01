package com.ryudnar.MusecaInfo.domain.Controller;

import com.ryudnar.MusecaInfo.domain.DTO.PlayerDataSaveRequestDto;
import com.ryudnar.MusecaInfo.domain.DTO.UserDataSaveRequestDto;
import com.ryudnar.MusecaInfo.domain.Service.PlayerDataService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/player")
public class PlayerDataController {
  private PlayerDataService playerDataService;

  @PostMapping("/save")
  public Long savePlayerData(@RequestBody PlayerDataSaveRequestDto playerDataSaveRequestDto){
    return playerDataService.save(playerDataSaveRequestDto);
  }
}
