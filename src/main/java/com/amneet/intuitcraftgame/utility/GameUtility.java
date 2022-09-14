package com.amneet.intuitcraftgame.utility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amneet.intuitcraftgame.model.Player;
import com.amneet.intuitcraftgame.repository.PlayerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author amneetkaursawhney
 * Utility for DB communications
 */
@Component
public class GameUtility {
	
	@Autowired 
	PlayerRepository playerRepository;
	
	private int count = 0;

	//add Player to DB
	public String addGameScore(Player player){
		
		String msg = "Score entered for " + player.getName();
		
		//writeTheScoreToFile(playerName, playerScore);
		
		count++;
		player.setId(count);
		
		playerRepository.save(player);
		
		return msg;
			
	}

	//Get Player Details by ID
	public String getPlayerById(int id) {
		
		return playerRepository.findById(id).get().toString();
	}

	//Get List of All Players
	public List<Player> getAllPlayers() {
		
		List<Player> playersList = new ArrayList<Player>();
		playerRepository.findAll().forEach(player -> playersList.add(player));
		return playersList;
		
	}
	
	//Get Players by Top Scores
	public List<Player> findTopN(int n) {
		return playerRepository.findTopN(n);
	}
	
	//Delete Player by Id
    public boolean deletePlayerById(int id) {
    	
    	playerRepository.deleteById(id);
        return getPlayerById(id) == null;
    }

	
    //Writing Data to File
//	public void writeTheScoreToFile(String name, int score){
//		
//      Random rand = new Random();
//      int rand_int1 = rand.nextInt(100);
//
//		 count++;
//	     Player player = new Player();
//	     player.setId(count);
//	     player.setName(name);
//	     player.setScore(score);
//	      
//	     FileWriteUtility.writeDataInTheFile(player);
//
//  }

}
