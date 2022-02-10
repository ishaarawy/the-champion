package com.ahmedshaarawy.thechampion.core;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
@Table(name = "base_entity")
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

}