package org.molsbee.movie.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.molsbee.movie.config.PersistenceConfig;
import org.molsbee.movie.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceConfig.class)
@ActiveProfiles("local")
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    @Transactional
    public void findByTitle() {
        // arrange
        final String title = "Green Lantern";

        // act
        Movie movie = movieRepository.findByTitle(title);

        // assert
        assertNotNull(movie);
    }

}
