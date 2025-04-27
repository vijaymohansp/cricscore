package com.java.cricscore.controller;

import com.java.cricscore.model.PlayerData;
import com.java.cricscore.respository.PlayerRepo;
import com.java.cricscore.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cric")
public class ScoreController {

    @Autowired
    PlayerRepo playerRepo;

    @Autowired
    PlayerService playerService;

    @GetMapping("/playerData")
    @ResponseStatus(HttpStatus.CREATED)
    public List<PlayerData> allPlayerData(){
        List<PlayerData> playerData = playerRepo.fillPlayerData();
        return playerData;
    }

    @PostMapping("/addData")
    public void addNewPlayerData(@RequestBody PlayerData playerData){
        playerService.addNewPlayerData(playerData);
    }

    @GetMapping("/{playerName}")
    public PlayerData getOnePlayerData(@PathVariable String playerName){
        PlayerData oneplayerData = playerService.getOneplayerData(playerName);
        return oneplayerData;
    }


    @PutMapping("/updateData")
    public void updateOnePlayerData(@RequestBody PlayerData playerData){
        playerService.updatePlayerData(playerData);
    }

    @DeleteMapping("/{playerName}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePlayerData(@PathVariable String playerName){
        playerService.deleteplayerData(playerName);
    }
}
