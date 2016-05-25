package org.molsbee.movie.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.molsbee.movie.model.omdb.Search;
import org.molsbee.movie.model.omdb.TitleResponse;
import org.molsbee.movie.model.omdb.TitleSearchResponse;
import org.springframework.web.client.RestTemplate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MovieLookupTest {

    @Mock private RestTemplate restTemplate;
    @InjectMocks private MovieLookup lookupService;

    private static ObjectMapper mapper = new ObjectMapper();
    private static TitleResponse omdbTitleResponse;
    private static Search omdbSearchResponse;

    @BeforeClass
    public static void testSetup() throws IOException {
        omdbTitleResponse = mapper.readValue(IOUtils.toString(new FileInputStream("src/test/resources/org/molsbee/movie/service/omdb-response.json")), TitleResponse.class);
        omdbSearchResponse = mapper.readValue(IOUtils.toString(new FileInputStream("src/test/resources/org/molsbee/movie/service/movie-search.json")), Search.class);
    }

    @Test
    public void getMovieByTitle() throws Exception {
        // arrange
        String movieTitle = "Green Lantern";
        String uri = "http://www.omdbapi.com/?t=Green+Lantern&y=&plot=short&r=json";
        when(restTemplate.getForObject(uri, TitleResponse.class)).thenReturn(omdbTitleResponse);

        // act
        TitleResponse actualResponse = lookupService.getMovieByTitle(movieTitle);

        // assert
        assertEquals(omdbTitleResponse.getTitle(), actualResponse.getTitle());
        assertEquals(omdbTitleResponse.getYear(), actualResponse.getYear());
        assertEquals(omdbTitleResponse.getRated(), actualResponse.getRated());
        assertEquals(omdbTitleResponse.getReleased(), actualResponse.getReleased());
        assertEquals(omdbTitleResponse.getRuntime(), actualResponse.getRuntime());
        assertEquals(omdbTitleResponse.getGenre(), actualResponse.getGenre());
        assertEquals(omdbTitleResponse.getDirector(), actualResponse.getDirector());
        assertEquals(omdbTitleResponse.getWriter(), actualResponse.getWriter());
        assertEquals(omdbTitleResponse.getActors(), actualResponse.getActors());
        assertEquals(omdbTitleResponse.getPlot(), actualResponse.getPlot());
        assertEquals(omdbTitleResponse.getLanguage(), actualResponse.getLanguage());
        assertEquals(omdbTitleResponse.getCountry(), actualResponse.getCountry());
        assertEquals(omdbTitleResponse.getAwards(), actualResponse.getAwards());
        assertEquals(omdbTitleResponse.getPoster(), actualResponse.getPoster());
        assertEquals(omdbTitleResponse.getMetascore(), actualResponse.getMetascore());
        assertEquals(omdbTitleResponse.getImdbRating(), actualResponse.getImdbRating());
        assertEquals(omdbTitleResponse.getImdbVotes(), actualResponse.getImdbVotes());
        assertEquals(omdbTitleResponse.getImdbId(), actualResponse.getImdbId());
        assertEquals(omdbTitleResponse.getType(), actualResponse.getType());
    }

    @Test
    public void searchMovieByTitle() throws Exception {
        // arrange
        String movieTitle = "Green";
        String uri = "http://www.omdbapi.com/?s=" + movieTitle + "&y=&plot=short&r=json";
        when(restTemplate.getForObject(uri, Search.class)).thenReturn(omdbSearchResponse);

        // act
        List<TitleSearchResponse> response = lookupService.searchMovieByTitle(movieTitle);

        // assert
        assertNotNull(response);
    }

}
