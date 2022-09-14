package com.amneet.intuitcraftgame.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amneet.intuitcraftgame.model.Player;
import com.amneet.intuitcraftgame.repository.PlayerRepository;
import com.amneet.intuitcraftgame.utility.FileReadUtility;
import com.amneet.intuitcraftgame.utility.GameUtility;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author amneetkaursawhney
 * Service Implementation
 */
@Service
public class GameServiceImpl implements GameService{

	@Autowired
    GameUtility gameUtility;

//    @Autowired
//    FileReadUtility fileReadUtility;
    
    
    //addorUpdateToRepoOrFile
    @Override
	public String addGameScore(Player player)  {
		
    	return gameUtility.addGameScore(player);
		
	}
    
    //getPlayerById
    @Override
	public String getPlayerById(int id){
    	
		return gameUtility.getPlayerById(id);
			
	}
    
    //getAllPlayers
    @Override
    public List<Player> getAllPlayers(){
    	
    	return gameUtility.getAllPlayers();
    	
    }
	
	//getTopScoresAndPlayers 
	@Override
	public List<Player> findTopN(int n) {
		return gameUtility.findTopN(n);
	}
	
	//deleteFromRepo
    @Override
    public boolean deletePlayerById(int id){
    	
    	return gameUtility.deletePlayerById(id);
    	
    }


}
