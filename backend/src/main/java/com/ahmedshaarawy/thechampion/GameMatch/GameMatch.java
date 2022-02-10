package com.ahmedshaarawy.thechampion.GameMatch;

import com.ahmedshaarawy.thechampion.GameRound.GameRound;
import com.ahmedshaarawy.thechampion.Participant.Participant;
import com.ahmedshaarawy.thechampion.core.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="game_match")
public class GameMatch extends BaseEntity {

    @ManyToOne
    Participant firstParticipant;

    @ManyToOne
    Participant secondParticipant;

    @ManyToOne
    Participant winner;

    @Column
    LocalDateTime gameTime;

    @OneToOne
    GameRound gameRound;

    public Boolean isGameFinished(){
        return winner!=null;
    }
}