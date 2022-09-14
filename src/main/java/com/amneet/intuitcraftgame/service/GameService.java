package com.amneet.intuitcraftgame.service;

import java.util.List;

import com.amneet.intuitcraftgame.model.Player;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface GameService {
	
	public String addGameScore(Player player);

	public String getPlayerById(int id);

	public List<Player> getAllPlayers();

	public boolean deletePlayerById(int id);

	public Player getPlayerByName(String name);

	public List<Player> getTopPlayerByName(String name);

	List<Player> findTopN(int n);

}
