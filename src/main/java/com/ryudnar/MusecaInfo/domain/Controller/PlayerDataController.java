package com.ryudnar.MusecaInfo.domain.Controller;

import com.ryudnar.MusecaInfo.domain.DTO.PlayerDataSaveRequestDto;
import com.ryudnar.MusecaInfo.domain.DTO.UserDataSaveRequestDto;
import com.ryudnar.MusecaInfo.domain.Service.PlayerDataService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/player")
public class PlayerDataController {
  private PlayerDataService playerDataService;

  // 플레이어 정보 보여주는 페이지
  // 기본 정보 말고 뭐 더 보여줘야 할 게 있나?
  @GetMapping("/")
  public String main() {
    return "main";
  }

  @PostMapping("/save")
  public Long savePlayerData(@RequestBody PlayerDataSaveRequestDto playerDataSaveRequestDto){
    return playerDataService.save(playerDataSaveRequestDto);
  }
}
