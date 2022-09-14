package com.amneet.intuitcraftgame.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.amneet.intuitcraftgame.model.Player;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@DataJpaTest
public class PlayerRepositoryTest {
	
	@Autowired
	PlayerRepository playerRepository;
	
	@Test
    public void test_SavePlayer() {

        Player player = new Player();
        player.setId(1);
        player.setScore(50);
        player.setName("name");
        playerRepository.save(player);

        Player savedPlayer = playerRepository.findById(1).get();

        assertNotNull(savedPlayer);
        assertEquals(savedPlayer.getName(), player.getName());
    }

    public void test_PlayerIsNotPresent() {
        
        NoSuchElementException thrown = Assertions.assertThrows(NoSuchElementException.class, () -> {
        	
        	Player player = new Player();
        	player.setId(1);
            player.setScore(50);
            player.setName("name");
            playerRepository.save(player);
            playerRepository.findById(2).get();
            
        });
        
        Assertions.assertEquals("NoSuchElementException", thrown.getMessage());

        
    }

}
