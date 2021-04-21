package com.example.VotingSystem.entities;

import lombok.*;
import javax.persistence.*;


@Data
@Table(name="citizens")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Citizen {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String username;
    private String lastName;
    private Boolean hasVoted;
    private String IDC;
    private String city;
    private String street;
}

