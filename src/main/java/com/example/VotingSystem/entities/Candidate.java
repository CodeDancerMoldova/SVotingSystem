package com.example.VotingSystem.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name="candidates")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Candidate {
    @Id

    @SequenceGenerator(
            name = "candidate_sequence",
            sequenceName = "candidate_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tcandidate_sequence"
    )
    @Column(name = "id")
    private int id;
    @Column(name = "candidate_name")
    private String name;

    @Column(name = "numberOfVotes")
    private int numberofVotes;

    public Candidate(String name, int numberofVotes) {
        this.name = name;
        this.numberofVotes = numberofVotes;
    }
}
