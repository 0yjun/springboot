package com.camss.helloJpa.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue
    @Column(name = "team_id")
    private Long id;

    @Column
    private String name;

    @OneToMany
    @JoinColumn(name = "team_id")
    private List<Member> members = new ArrayList<>();
}