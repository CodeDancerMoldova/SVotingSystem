package com.example.VotingSystem.repositories;

import com.example.VotingSystem.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepo extends JpaRepository<Candidate,Long> {
            public Candidate findById(int id);
}
