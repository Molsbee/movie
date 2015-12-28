package com.molsbee.movie.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.molsbee.movie.model.OmdbResponse;
import org.apache.commons.io.IOUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MovieLookupTest {

    @Mock private RestTemplate restTemplate;
    @InjectMocks private MovieLookup lookupService;

    private static OmdbResponse omdbResponse;
    private static ObjectMapper mapper = new ObjectMapper();

    @BeforeClass
    public static void testSetup() throws IOException {
        String greenLanter = IOUtils.toString(new FileInputStream("src/test/resources/com/molsbee/movie/service/omdb-response.json"));
        omdbResponse = mapper.readValue(greenLanter, OmdbResponse.class);
    }

    @Test
    public void getMovieByTitle() throws UnsupportedEncodingException {
        // arrange
        String movieTitle = "Green Lantern";
        String uri = "http://www.omdbapi.com/?t=Green+Lantern&y=&plot=full&r=json";
        when(restTemplate.getForObject(uri, OmdbResponse.class)).thenReturn(omdbResponse);

        // act
        OmdbResponse actualResponse = lookupService.getMovieByTitle("Green Lantern");

        // assert
        assertEquals("Green Lantern", actualResponse.getTitle());
        assertEquals("Green Lantern", omdbResponse.getTitle());
        assertEquals("2011", omdbResponse.getYear());
        assertEquals("PG-13", omdbResponse.getRated());
        assertEquals("17 Jun 2011", omdbResponse.getReleased());
        assertEquals("114 min", omdbResponse.getRuntime());
        assertEquals("Action, Adventure, Sci-Fi", omdbResponse.getGenre());
        assertEquals("Martin Campbell", omdbResponse.getDirector());
        assertEquals("Greg Berlanti (screenplay), Michael Green (screenplay), Marc Guggenheim (screenplay), Michael Goldenberg (screenplay), Greg Berlanti (screen story), Michael Green (screen story), Marc Guggenheim (screen story)", omdbResponse.getWriter());
        assertEquals("Ryan Reynolds, Blake Lively, Peter Sarsgaard, Mark Strong", omdbResponse.getActors());
        assertEquals("Reckless test pilot Hal Jordan is granted an alien ring that bestows him with otherworldly powers that inducts him into an intergalactic police force, the Green Lantern Corps.", omdbResponse.getPlot());
        assertEquals("English", omdbResponse.getLanguage());
        assertEquals("USA", omdbResponse.getCountry());
        assertEquals("1 win & 5 nominations.", omdbResponse.getAwards());
        assertEquals("http://ia.media-imdb.com/images/M/MV5BMTMyMTg3OTM5Ml5BMl5BanBnXkFtZTcwNzczMjEyNQ@@._V1_SX300.jpg", omdbResponse.getPoster());
        assertEquals("39", omdbResponse.getMetascore());
        assertEquals("5.7", omdbResponse.getImdbRating());
        assertEquals("197161", omdbResponse.getImdbVotes());
        assertEquals("tt1133985", omdbResponse.getImdbId());
        assertEquals("movie", omdbResponse.getType());
        assertEquals("True", omdbResponse.getResponse());
    }

}
