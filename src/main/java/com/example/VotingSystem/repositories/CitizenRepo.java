package com.example.VotingSystem.repositories;

import com.example.VotingSystem.entities.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenRepo extends JpaRepository<Citizen,Long>{
      @Query("select u from Citizen u where u.IDC = ?1")
      public Citizen findByIDC(String IDC);
}
