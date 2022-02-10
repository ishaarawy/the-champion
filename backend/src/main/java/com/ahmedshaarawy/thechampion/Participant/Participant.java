package com.ahmedshaarawy.thechampion.Participant;

import com.ahmedshaarawy.thechampion.core.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "participant")
public class Participant extends BaseEntity {

    @Column
    String name;

}