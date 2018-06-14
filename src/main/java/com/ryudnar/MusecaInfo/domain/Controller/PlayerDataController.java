package com.ryudnar.MusecaInfo.domain.Controller;

import com.ryudnar.MusecaInfo.domain.DTO.PlayerDataSaveRequestDto;
import com.ryudnar.MusecaInfo.domain.Service.PlayerDataService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/player")
public class PlayerDataController {
  @Autowired
  private PlayerDataService playerDataService;

  // 플레이어 정보 보여주는 페이지
  // 기본 정보 말고 뭐 더 보여줘야 할 게 있나?
  @GetMapping("/")
  public String main() {
    return "player/main";
  }

  @CrossOrigin
  @ResponseStatus(value = HttpStatus.OK)
  @PostMapping("/save")
  public void savePlayerData(@RequestBody PlayerDataSaveRequestDto playerDataSaveRequestDto){
    playerDataService.save(playerDataSaveRequestDto);
  }
}
