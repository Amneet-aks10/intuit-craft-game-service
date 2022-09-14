package com.amneet.intuitcraftgame.utility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amneet.intuitcraftgame.model.Player;
import com.amneet.intuitcraftgame.repository.PlayerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;

@Component
public class GameUtility {
	
	@Autowired 
	PlayerRepository playerRepository;
	
	private int count = 0;

	public String addGameScore(Player player){
		
		String msg = "Score entered for " + player.getName();
		
		//writeTheScoreToFile(playerName, playerScore);
		
		count++;
		player.setId(count);
		
		playerRepository.save(player);
		
		return msg;
			
	}

	public String getPlayerById(int id) {
		
		return playerRepository.findById(id).get().toString();
	}

	public List<Player> getAllPlayers() {
		
		List<Player> playersList = new ArrayList<Player>();
		playerRepository.findAll().forEach(player -> playersList.add(player));
		return playersList;
		
	}
	
    public boolean deletePlayerById(int id) {
    	
    	playerRepository.deleteById(id);
        return getPlayerById(id) == null;
    }

	public Player getPlayerByName(String name) {
		
		return playerRepository.findByName(name);
		
	}

	public List<Player> getTopPlayerByName(String name) {
		
		return playerRepository.findTop5ByName(name);
		
	}
	
	
	public List<Player> findTopN(int n) {
		return playerRepository.findTopN(n);
	}

	
//	public void writeTheScoreToFile(String name, int score){
//		
////      Random rand = new Random();
////      int rand_int1 = rand.nextInt(100);
////      
////      Player player = Player.builder()
////              .id(count)
////              .name(name)
////              .score(score)
////              .build();
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
