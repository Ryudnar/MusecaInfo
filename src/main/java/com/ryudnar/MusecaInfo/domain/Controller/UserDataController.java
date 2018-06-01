package com.ryudnar.MusecaInfo.domain.Controller;

import com.ryudnar.MusecaInfo.domain.DTO.UserDataSaveRequestDto;
import com.ryudnar.MusecaInfo.domain.Repository.UserDataRepository;
import com.ryudnar.MusecaInfo.domain.Service.UserDataService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserDataController {
    private UserDataService userDataService;

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody UserDataSaveRequestDto userDataSaveRequestDto){
        return userDataService.save(userDataSaveRequestDto);
    }
}