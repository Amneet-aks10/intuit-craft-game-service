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

@RestController
public class CraftDemoGameController {
	
	@Autowired
	GameService gameService;
	
	@PostMapping("/storePlayerScore")
    public ResponseEntity<String> savePlayerDetails(@RequestBody Player player) {
        return new ResponseEntity<>(gameService.addGameScore(player), HttpStatus.OK);
    }

    @GetMapping("/getAllPlayers")
    public ResponseEntity<List<Player>> getAllPlayer() {
        return new ResponseEntity<>(gameService.getAllPlayers(), HttpStatus.OK);
    }

    @GetMapping("/getPlayerById/{id}")
    public ResponseEntity<String> getPlayerById(@PathVariable int id) {
        return new ResponseEntity<>(gameService.getPlayerById(id), HttpStatus.OK);

    }
    
    @GetMapping("/getPlayerByName/{name}")
    public ResponseEntity<Player> getPlayerByName(@PathVariable String name) {
        return new ResponseEntity<>(gameService.getPlayerByName(name), HttpStatus.OK);

    }
    
    @GetMapping("/getTopPlayerByName/{name}")
    public ResponseEntity<List<Player>> getTopPlayerByName(@PathVariable String name) {
        return new ResponseEntity<>(gameService.getTopPlayerByName(name), HttpStatus.OK);

    }
    
    @GetMapping("/getTopPlayerByScore/{limit}")
    public ResponseEntity<List<Player>> getTopPlayerByScore(@PathVariable int limit) {
        return new ResponseEntity<>(gameService.findTopN(limit), HttpStatus.OK);

    }

//    //added
//    @GetMapping("/getTop5Players")
//    public ResponseEntity<List<Player>> getTop5ByScore() {
//        return new ResponseEntity<>(gameServiceImpl.getScore(), HttpStatus.OK);
//
//    }
    
    @DeleteMapping("/deletePlayerById/{id}")
    public boolean deleteOrder(@PathVariable int id) {
        return gameService.deletePlayerById(id);
    }

//    @GetMapping("/getTopScoreList")
//    public List<Player> getTopScorer(){
//        return gameServiceImpl.getScore();
//    }
//    
//    @GetMapping("/getAllScoreList")
//    public List<Player> getAllScorer(){
//        return gameServiceImpl.getAllPlayers();
//    }
//
//    @PostMapping("/storePlayerScore")
//    public ResponseEntity<String> startGame(@RequestBody PlayerDetails playerDetails){
//        String msg = "fail";
//        if(Objects.nonNull(playerDetails)) {
//            try {
//                msg = gameServiceImpl.addGameScore(playerDetails.getName(),playerDetails.getPlayerScore());
//            } catch (JsonProcessingException e) {
//                e.printStackTrace();
//            }
//        }
//        return new ResponseEntity(msg, HttpStatus.OK);
//    }

}
