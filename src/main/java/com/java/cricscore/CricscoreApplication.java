package com.java.cricscore;

import com.java.cricscore.respository.PlayerRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CricscoreApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CricscoreApplication.class, args);
//		PlayerRepo playerRepo = context.getBean("playerRepo", PlayerRepo.class);
//		playerRepo.fillPlayerData();
	}

}
