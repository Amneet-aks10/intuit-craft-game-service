package com.amneet.intuitcraftgame.integration;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.amneet.intuitcraftgame.IntuitCraftGameAksApplication;
import com.amneet.intuitcraftgame.model.Player;


@SpringBootTest(classes = IntuitCraftGameAksApplication.class,
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CraftDemoGameControllerIntegrationTest {
	
    private int port = 8080;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();
    
    @Test
    public void testAddPlayerAPI() throws JSONException {
        Player player = new Player();
        player.setId(1);
        player.setName("Amneet");
        player.setScore(50);

        HttpEntity<Player> entity = new HttpEntity<Player>(player, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/storePlayerScore"),
                HttpMethod.POST, entity, String.class);

        String expected = "Score entered for Amneet";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }
    
    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }


}
