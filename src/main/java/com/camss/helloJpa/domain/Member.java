package com.camss.helloJpa.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@NoArgsConstructor
//@RequiredArgsConstructor
//@AllArgsConstructor
//@Setter
//@Getter
@Entity
@Data
public class Member {

    @Id
    private int id;

    @Column(name = "psw")
    private String psw;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToMany(mappedBy = "id")
    private List<Order> orders = new ArrayList<>();


    public void changeTeam(Team team){
        this.team = team;
        team.getMembers().add(this);
    }



}
