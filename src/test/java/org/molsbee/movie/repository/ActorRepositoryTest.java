package org.molsbee.movie.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.molsbee.movie.config.PersistenceConfig;
import org.molsbee.movie.model.database.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceConfig.class)
@ActiveProfiles("local")
public class ActorRepositoryTest {

    @Autowired
    private ActorRepository actorRepository;

    @Test
    @Transactional
    public void findByFirstNameAndLastName() {
        // arrange
        String firstName = "Ryan";
        String lastName = "Reynolds";

        // act
        Actor actor =  actorRepository.findByFirstNameAndLastName(firstName, lastName).get();

        // assert
        assertNotNull(actor);
        assertEquals(firstName, actor.getFirstName());
        assertEquals(lastName, actor.getLastName());
    }

}
