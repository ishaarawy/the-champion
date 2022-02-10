package com.ahmedshaarawy.thechampion.Participant;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {

    @Autowired
    ParticipantRepository rep;

    Participant create(Participant participant){
        return rep.save(participant);
    }

    public List<Participant> findAll(){
        return Lists.newArrayList(rep.findAll());
    }

}
