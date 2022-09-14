package com.amneet.intuitcraftgame.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.amneet.intuitcraftgame.*;
import com.amneet.intuitcraftgame.model.Player;
import com.amneet.intuitcraftgame.service.GameService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(CraftDemoGameController.class)
public class CraftDemoGameControllerTest {
	
	@Autowired
    private MockMvc mvc;

    @MockBean
    private GameService gameService;
    
    @Test
    public void getAllPlayerAPI() throws Exception {

        List<Player> playerList = new ArrayList<>();
        Player player = new Player();
        player.setId(1);
        player.setName("Amneet");
        player.setScore(50);
        playerList.add(player);

        when(gameService.getAllPlayers()).thenReturn(playerList);
        mvc.perform(MockMvcRequestBuilders
                .get("/getAllPlayers")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].id").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].id").value(1));
    }

}
