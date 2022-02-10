package com.ahmedshaarawy.thechampion.Participant;

import com.ahmedshaarawy.thechampion.GameMatch.GameMatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("participant")
public class ParticipantController {

    @Autowired
    ParticipantService participantService;

    @PostMapping("")
    public Participant create(@RequestBody Participant participant){
        return participantService.create(participant);
    }

    @RequestMapping("/all")
    public List<Participant> findAll(){
        return participantService.findAll();
    }

}
