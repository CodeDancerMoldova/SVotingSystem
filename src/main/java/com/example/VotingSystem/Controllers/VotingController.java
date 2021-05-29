package com.example.VotingSystem.Controllers;
import com.example.VotingSystem.Services.CitizenService;
import com.example.VotingSystem.entities.Citizen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;



@Controller
public class VotingController {

    private CitizenService citizenService;

    @Autowired
    public VotingController(CitizenService citizenService) {
        this.citizenService = citizenService;
    }

    @PostMapping("/doLogin")
    public  String doLogin(@Valid Citizen citizen, HttpSession session, Model model){
              return citizenService.doLogin(citizen,session,model);
    }

    @RequestMapping("/voteFor")
    public String voteFor(@RequestParam int id, HttpSession session) {
          return  citizenService.voteFor(id,session);
    }

    @GetMapping("")
    public String doAction(Model model) {
        model.addAttribute("citizen",new Citizen());
        return "vote";
    }

}
/*@Autowired
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
    }*/


  