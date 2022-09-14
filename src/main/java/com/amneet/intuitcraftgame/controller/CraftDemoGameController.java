package com.amneet.intuitcraftgame.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amneet.intuitcraftgame.model.Player;
import com.amneet.intuitcraftgame.service.GameService;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author amneetkaursawhney
 * Rest Controller 
 */
@RestController
public class CraftDemoGameController {
	
	@Autowired
	GameService gameService;
	
	//Add Player Score
	@PostMapping("/storePlayerScore")
    public ResponseEntity<String> savePlayerDetails(@RequestBody Player player) {
        return new ResponseEntity<>(gameService.addGameScore(player), HttpStatus.OK);
    }

	//Get List of All Players
    @GetMapping("/getAllPlayers")
    public ResponseEntity<List<Player>> getAllPlayer() {
        return new ResponseEntity<>(gameService.getAllPlayers(), HttpStatus.OK);
    }

    //Get Player by Id
    @GetMapping("/getPlayerById/{id}")
    public ResponseEntity<String> getPlayerById(@PathVariable int id) {
        return new ResponseEntity<>(gameService.getPlayerById(id), HttpStatus.OK);

    }
    
    //Get top scores and Player details
    @GetMapping("/getTopPlayerByScore/{limit}")
    public ResponseEntity<List<Player>> getTopPlayerByScore(@PathVariable int limit) {
        return new ResponseEntity<>(gameService.findTopN(limit), HttpStatus.OK);

    }
    
    //Delete player by Id
    @DeleteMapping("/deletePlayerById/{id}")
    public boolean deleteOrder(@PathVariable int id) {
        return gameService.deletePlayerById(id);
    }
    
    @GetMapping("/health")
    public String healthCheck()
    {
    	return "Game Service is Working!!";
    }

}
