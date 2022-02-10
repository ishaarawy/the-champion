package com.ahmedshaarawy.thechampion.GameRound;

import com.ahmedshaarawy.thechampion.GameMatch.GameMatch;
import com.ahmedshaarawy.thechampion.GameMatch.GameMatchService;
import com.ahmedshaarawy.thechampion.Participant.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameRoundService {

    @Autowired
    GameRoundRepository rep;

    @Autowired
    GameMatchService gameMatchService;

    public GameRound save(List<Participant> participants){
        List<GameMatch> gameMatches = gameMatchService.save(participants);
        GameRound gameRound = new GameRound();
        gameRound.setGameMatches(gameMatches);
        return rep.save(gameRound);
    }

}
