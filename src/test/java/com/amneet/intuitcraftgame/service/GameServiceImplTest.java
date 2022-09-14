package com.amneet.intuitcraftgame.service;


import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.amneet.intuitcraftgame.model.Player;
import com.amneet.intuitcraftgame.repository.PlayerRepository;

import org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class GameServiceImplTest {
	
	@InjectMocks
    private GameServiceImpl gameServiceImpl;

	@Autowired
    private PlayerRepository playerRepository;

    @Test
    public void whenGetAllPlayer_thenReturnPlayerList() {

        List<Player> playerList = new ArrayList<>();
        Player player = new Player();
        player.setId(1);
        player.setName("Amneet");
        player.setScore(50);
        playerRepository.save(player);
        playerList.add(player);

        Mockito.when(playerRepository.findAll()).thenReturn(playerList);

        List<Player> returnedOrderList = gameServiceImpl.getAllPlayers();
        Assertions.assertEquals(returnedOrderList.size(), playerList.size());


    }


}
