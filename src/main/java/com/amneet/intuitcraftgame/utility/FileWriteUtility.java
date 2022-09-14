package com.amneet.intuitcraftgame.utility;

import java.io.FileWriter;

import org.springframework.stereotype.Component;

import com.amneet.intuitcraftgame.model.Player;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class FileWriteUtility {

	private static final String FILE_LOCATION = "/Users/amneetkaursawhney/Desktop/intuit.txt";
    private static final String NEW_LINE_SEPRATOR = "\n";

        public static void writeDataInTheFile(Player object) throws JsonProcessingException {
        	
            ObjectMapper mapper = new ObjectMapper();
            String msg = mapper.writeValueAsString(object);
            
            if(msg != null && !msg.isEmpty()) {
                try {
                    FileWriter fw = new FileWriter(FILE_LOCATION, true);
                    fw.write(msg+NEW_LINE_SEPRATOR);
                    fw.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
                System.out.println("Score added to file");
            }
            
        }

}
