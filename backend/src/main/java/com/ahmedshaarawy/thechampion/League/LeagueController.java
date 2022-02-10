package com.ahmedshaarawy.thechampion.League;

import com.ahmedshaarawy.thechampion.Participant.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("league")
public class LeagueController {

    @Autowired
    LeagueService leagueService;

    @GetMapping("/all")
    List<League> getAll(){
        return leagueService.getAll();
    }

    @PostMapping("")
    League create(@RequestBody List<Participant> participant){
        return leagueService.save(participant);
    }

    @PostMapping("generate-random")
    League generateRandom(){
        return leagueService.generateRandom();
    }

    @PutMapping("/close-last-round")
    League create(@RequestBody League league){
        return leagueService.closeLastRound(league);
    }

}
