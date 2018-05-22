package net.youareatman;

import net.youareatman.model.AtmanUser;
import net.youareatman.rest.repositories.AtmanUserRepository;
import net.youareatman.rest.services.AtmanUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hibernate.validator.internal.util.Contracts.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class AtmanUserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AtmanUserRepository atmanUserRepository;

    @Test
    public void addTest(){
        AtmanUser atmanUserMirko = new AtmanUser(new Date(),"mirko@arnes.si","1234");
        entityManager.persist(atmanUserMirko);
        entityManager.flush();

        AtmanUser foundById = atmanUserRepository.findById(atmanUserMirko.getUserEmail()).orElse(new AtmanUser(new Date(),"invalid",""));

        assertThat(foundById.getUserEmail()).isEqualTo(atmanUserMirko.getUserEmail());
    }


}
