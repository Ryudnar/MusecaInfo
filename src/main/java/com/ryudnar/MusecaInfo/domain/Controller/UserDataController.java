package com.ryudnar.MusecaInfo.domain.Controller;

import com.ryudnar.MusecaInfo.domain.Entity.UserDataEntity;
import com.ryudnar.MusecaInfo.domain.Repository.UserDataRepository;
import com.ryudnar.MusecaInfo.domain.Service.UserDataService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserDataController {
    private UserDataRepository userDataRepository;

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody UserDataService userDataService){
        userDataRepository.save(userDataService.toEntity());
    }
}