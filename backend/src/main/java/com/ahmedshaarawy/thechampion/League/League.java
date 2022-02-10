package com.ahmedshaarawy.thechampion.League;

import com.ahmedshaarawy.thechampion.GameMatch.GameMatch;
import com.ahmedshaarawy.thechampion.GameRound.GameRound;
import com.ahmedshaarawy.thechampion.Participant.Participant;
import com.ahmedshaarawy.thechampion.core.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "league")
public class League extends BaseEntity {

    static Integer maxParticipantsCount = 12;

    @ManyToMany
    List<Participant> participants = new ArrayList<Participant>();

    @OneToMany
    List<GameRound> gameRounds = new ArrayList<GameRound>();

}