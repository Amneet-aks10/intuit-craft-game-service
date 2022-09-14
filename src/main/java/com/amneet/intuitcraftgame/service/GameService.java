package com.amneet.intuitcraftgame.service;

import java.util.List;

import com.amneet.intuitcraftgame.model.Player;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author amneetkaursawhney
 * Interface GameService 
 */
public interface GameService {
	
	public String addGameScore(Player player);

	public String getPlayerById(int id);

	public List<Player> getAllPlayers();

	public boolean deletePlayerById(int id);

	List<Player> findTopN(int n);

}
