package com.example.VotingSystem.Services;

import com.example.VotingSystem.entities.Candidate;
import com.example.VotingSystem.entities.Citizen;
import com.example.VotingSystem.repositories.CandidateRepo;
import com.example.VotingSystem.repositories.CitizenRepo;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
public class CitizenService {
    private final CitizenRepo citizenRepo;
    private final CandidateRepo candidateRepo;

    public CitizenService(CitizenRepo citizenRepo, CandidateRepo candidateRepo) {
        this.citizenRepo = citizenRepo;
        this.candidateRepo = candidateRepo;
    }

    public String doLogin(Citizen citizen, HttpSession session, Model model){

        try{
            Citizen citizenByIDC = citizenRepo.findCitizenByIDC(citizen.getIDC());
            if(citizenByIDC.getHasVoted()){
                return "/alreadyVoted";
            }
            else{
                session.setAttribute("citizen", citizenByIDC);
                List<Candidate> candidates = candidateRepo.findAll();
                model.addAttribute("candidates", candidates);
                return "/performVoted";
            }
        }
        catch (NullPointerException nullPointerException){
             return "noCitizen";
        }

    }

    public String voteFor(int id, HttpSession session) {
        Citizen citizen = (Citizen) session.getAttribute("citizen");
        if (!citizen.getHasVoted()) {
            citizen.setHasVoted(true);
            Candidate candidate = candidateRepo.findById(id);
            candidate.setNumberofVotes(candidate.getNumberofVotes() + 1);
            citizenRepo.save(citizen);
            candidateRepo.save(candidate);
            return "/voted";
        } else {
            return "/alreadyVoted";
        }
    }
}

