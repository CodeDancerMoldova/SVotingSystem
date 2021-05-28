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
    @SequenceGenerator(
            name = "citizen_sequence",
            sequenceName = "citizen_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "citizen_sequence"
    )

    private int id;
    private String username;
    private String lastName;
    private Boolean hasVoted;
    private String IDC;
    private String city;
    private String street;

    public Citizen(String username, String lastName, Boolean hasVoted, String IDC, String city, String street) {
        this.username = username;
        this.lastName = lastName;
        this.hasVoted = hasVoted;
        this.IDC = IDC;
        this.city = city;
        this.street = street;
    }
}

