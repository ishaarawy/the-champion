package com.ahmedshaarawy.thechampion.GameRound;

import com.ahmedshaarawy.thechampion.GameMatch.GameMatch;
import com.ahmedshaarawy.thechampion.core.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "game_round")
@Data
public class GameRound extends BaseEntity {

    @ManyToMany
    List<GameMatch> gameMatches = new ArrayList<GameMatch>();

    public Boolean isRoundFinished(){
        return gameMatches.stream().allMatch(gameMatch -> gameMatch.isGameFinished());
    }
}