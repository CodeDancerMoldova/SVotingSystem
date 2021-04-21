package com.example.VotingSystem.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name="candidates")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Candidate {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "candidate_name")
    private String name;

    @Column(name = "numberOfVotes")
    private int numberofVotes;

}
