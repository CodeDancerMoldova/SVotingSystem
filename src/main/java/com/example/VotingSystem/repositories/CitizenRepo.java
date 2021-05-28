package com.example.VotingSystem.repositories;

import com.example.VotingSystem.entities.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CitizenRepo extends JpaRepository<Citizen,Long>{
      public Citizen findCitizenByIDC(String idc);
}
