package com.java.cricscore.service;

import com.java.cricscore.model.PlayerData;
import com.java.cricscore.respository.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PlayerService {

    @Autowired
    PlayerRepo playerRepo;

    public void addNewPlayerData(PlayerData playerData){
        playerRepo.addNewData(playerData);
    }

    public PlayerData getOneplayerData(String playerName) {
        Optional<PlayerData> first = playerRepo.fillPlayerData()
                .stream()
                .filter(p -> p.getPlayerName().equals(playerName)).findFirst();
        if(first.isPresent()){
            return first.get();
        }
        return null;
    }

    public void updatePlayerData(PlayerData playerData) {
        Optional<PlayerData> first = playerRepo.fillPlayerData()
                .stream()
                .filter(p -> p.getPlayerName().equals(playerData.getPlayerName())).findFirst();
        if(first.isPresent()){
            PlayerData data = first.get();
            playerRepo.fillPlayerData().remove(data);
            PlayerData playerData1 = new PlayerData();
            playerData1.setScore(playerData.getScore());
            playerData1.setPlayerName(playerData.getPlayerName());
            playerData1.setVenue(playerData.getVenue());
            playerRepo.addNewData(playerData1);

        }
    }

    public void deleteplayerData(String playerName) {
        Optional<PlayerData> first = playerRepo.fillPlayerData()
                .stream().
                filter(p -> p.getPlayerName().equals(playerName)).findFirst();
        if(first.isPresent()) {
            PlayerData data = first.get();
            playerRepo.fillPlayerData().remove(data);
        }
    }
}
