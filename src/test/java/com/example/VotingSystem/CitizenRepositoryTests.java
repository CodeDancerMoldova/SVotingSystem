package com.example.VotingSystem;

import com.example.VotingSystem.entities.Citizen;
import com.example.VotingSystem.repositories.CitizenRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CitizenRepositoryTests {

    @Autowired
    private CitizenRepo citizenRepo;
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void testcrateCitizen()
    {
        Citizen citizen = new Citizen();
        citizen.setCity("Chisinau");
        citizen.setIDC("b221225");
        citizen.setLastName("Marcu");
        citizen.setUsername("Vadim");
        citizen.setStreet("Socoleni");
        Citizen savedCitizen=citizenRepo.save(citizen);
        Citizen citizen1= testEntityManager.find(Citizen.class,savedCitizen.getId());
        assertThat(citizen1.getIDC()).isEqualTo(citizen.getIDC());
    }

    @Test
    public  void testFindCitizenByIDC(){
        String idc = "b221225";
        Citizen citizen = citizenRepo.findByIDC(idc);
        assertThat(citizen).isNotNull();
    }
}
