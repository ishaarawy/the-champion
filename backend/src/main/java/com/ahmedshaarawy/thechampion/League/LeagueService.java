package com.ahmedshaarawy.thechampion.League;

import com.ahmedshaarawy.thechampion.GameRound.GameRound;
import com.ahmedshaarawy.thechampion.GameRound.GameRoundService;
import com.ahmedshaarawy.thechampion.Participant.Participant;
import com.ahmedshaarawy.thechampion.Participant.ParticipantService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeagueService {

    @Autowired
    LeagueRepository rep;

    @Autowired
    GameRoundService gameRoundService;

    @Autowired
    ParticipantService participantService;

    public List<League> getAll(){
        return Lists.newArrayList(this.rep.findAll());
    }

    public League save(List<Participant> participants){
        if(participants.size()>League.maxParticipantsCount)
            return null; //should throw an error instead
        League league = new League();
        league.setParticipants(participants);
        GameRound gameRound = gameRoundService.save(participants);
        league.setGameRounds(Arrays.asList(gameRound));
        return rep.save(league);
    }

    public League generateRandom(){
        List<Participant> participants = participantService.findAll();
        Collections.shuffle(participants);
        return save(participants.stream().limit(League.maxParticipantsCount).collect(Collectors.toList()));
    }

    public League closeLastRound(League league){
        GameRound lastRound = league.getGameRounds().get(league.getGameRounds().size()-1);
        Boolean allLastRoundGamesFinished=lastRound.getGameMatches()
                .stream().allMatch(gameMatch -> gameMatch.isGameFinished());
        if(allLastRoundGamesFinished==false)
            return null; // throw error instead

        List<Participant> roundWinners = lastRound.getGameMatches()
                .stream().map(game->game.getWinner()).collect(Collectors.toList());
        if(roundWinners.size()==1){
            //send email
            return league;
        }
        else{
            GameRound newRound = gameRoundService.save(roundWinners);
            league.getGameRounds().add(newRound);
            return rep.save(league);
        }
    }

}
