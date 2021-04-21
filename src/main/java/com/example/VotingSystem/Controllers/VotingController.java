package com.example.VotingSystem.Controllers;

import com.example.VotingSystem.entities.Candidate;
import com.example.VotingSystem.entities.Citizen;
import com.example.VotingSystem.repositories.CandidateRepo;
import com.example.VotingSystem.repositories.CitizenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpSession;
import java.util.List;
@Controller
public class VotingController {

    @Autowired
    private CitizenRepo citizenRepo;
    @Autowired
    private CandidateRepo candidateRepo;



@GetMapping("")
public String doAction(Model model) {
    model.addAttribute("citizen",new Citizen());
    return "vote";
}


  @PostMapping("/doLogin")
    public String doLogin(Citizen citizen, HttpSession session,Model model) {

    Citizen citizen1= citizenRepo.findByIDC(citizen.getIDC());
      session.setAttribute("citizen", citizen1);
       if (!citizen1.getHasVoted()) {
            List<Candidate> candidates = candidateRepo.findAll();
            model.addAttribute("candidates", candidates);
            return "/performVoted";
        } else {
            return "/alreadyVoted";
       }
    }


    @RequestMapping("/voteFor")
    public String voteFor(@RequestParam int id, HttpSession session) {
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



  