package com.ahmedshaarawy.thechampion.GameMatch;

import com.ahmedshaarawy.thechampion.Participant.Participant;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameMatchService {

    @Autowired
    GameMatchRepository rep;

    GameMatch save(GameMatch gameMatch){
        return rep.save(gameMatch);
    }

    List<GameMatch> saveAll(List<GameMatch> gameMatches){
        return Lists.newArrayList(rep.saveAll(gameMatches));
    }

    public List<GameMatch> save(List<Participant> participants){
        List<GameMatch> gameMatches = new ArrayList<GameMatch>();
        Collections.shuffle(participants);
        for (int i = 0; i < participants.size(); i+=2) {
            GameMatch newMatch = new GameMatch();
            newMatch.setFirstParticipant(participants.get(i));
            if(i+1 == participants.size())
                newMatch.setWinner(participants.get(i));
            else
                newMatch.setSecondParticipant(participants.get(i+1));
            gameMatches.add(newMatch);
        }
        return Lists.newArrayList(rep.saveAll(gameMatches));
    }

}
