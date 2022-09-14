package com.amneet.intuitcraftgame.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Component;

import com.amneet.intuitcraftgame.model.Player;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class FileReadUtility {
	
	private static final String FILE_LOCATION = "/Users/amneetkaursawhney/Desktop/intuit.txt";

    public  Map<Integer,Player> readFileData() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        File file = new File(FILE_LOCATION);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        
        Map<Integer,Player> map= new TreeMap<>(Collections.reverseOrder());
        
        while ((st = br.readLine()) != null) {
            try {
                Player player = mapper.readValue(st, Player.class);
                map.put(player.getScore(),player);
            } catch (JsonGenerationException e) {

                e.printStackTrace();

            } catch (JsonMappingException e) {

                e.printStackTrace();

            } catch (IOException e) {

                e.printStackTrace();

            }
        }

       return map;
    }

}
