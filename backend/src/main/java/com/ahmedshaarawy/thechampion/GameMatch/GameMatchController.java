package com.ahmedshaarawy.thechampion.GameMatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("game-match")
public class GameMatchController {

    @Autowired
    GameMatchService gameMatchService;

    @PutMapping("/set-match-winner")
    GameMatch setMatchWinner(@RequestBody GameMatch gameMatch){
        return gameMatchService.save(gameMatch);
    }

    @PutMapping("/set-matches-winner")
    List<GameMatch> setMatchesWinner(@RequestBody List<GameMatch> gameMatches){
        return gameMatchService.saveAll(gameMatches);
    }
}
