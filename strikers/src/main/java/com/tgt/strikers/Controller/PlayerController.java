package com.tgt.strikers.Controller;

import com.tgt.strikers.model.players;
import com.tgt.strikers.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    //-------------------------------------------------Create New Player-------------------------------------------------
    @PostMapping("/player")
    public players createPlayer(@Valid @RequestBody players players) {
        players.setPlayer_id(UUID.randomUUID());
        return playerService.createPlayer(players);
    }

    //-------------------------------------------------Get All Player---------------------------------------------------
    @GetMapping("/players")
    public List<players> getAllPlayer() {

        return playerService.getAllPlayer();
    }

    //-----------------------------------------------Get Player By ID ---------------------------------------------------
    @GetMapping(value = "/player/{id}")
    public players getPlayerById(@PathVariable("id") UUID id) {

        return playerService.getPlayerById(id);
    }

    //-----------------------------------------------Update Player By ID ------------------------------------------------
    @PutMapping(value = "/player/{id}")
    public players updatePlayerById(@PathVariable("id") UUID id, @RequestBody players players) {
        return playerService.updatePlayerById(id, players);
    }

    //-------------------------------------------------Delete Player By ID ----------------------------------------------
    @DeleteMapping(value = "/player/{id}")
    public String deletePlayerById(@PathVariable("id") UUID id) {
        playerService.deletePlayerById(id);
        return "Player with id " + id + " has been deleted!";
    }
}