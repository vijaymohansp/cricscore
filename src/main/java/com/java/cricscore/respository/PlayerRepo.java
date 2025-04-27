package com.java.cricscore.respository;

import com.java.cricscore.model.PlayerData;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlayerRepo {

    static List<PlayerData> playerData = new ArrayList<>();

    static {
        PlayerData playerData1 = new PlayerData();
        playerData1.setScore(80);
        playerData1.setPlayerName("Rohit");
        playerData1.setVenue("MI");
        playerData.add(playerData1);

        PlayerData playerData2 = new PlayerData();
        playerData2.setScore(60);
        playerData2.setPlayerName("Kohli");
        playerData2.setVenue("BLR");
        playerData.add(playerData2);
    }

    public List<PlayerData> fillPlayerData(){
        return playerData;
    }

    public void addNewData(PlayerData pd){
        PlayerData playerData1 = new PlayerData();
        playerData1.setScore(pd.getScore());
        playerData1.setPlayerName(pd.getPlayerName());
        playerData1.setVenue(pd.getVenue());
        playerData.add(playerData1);
    }
}
