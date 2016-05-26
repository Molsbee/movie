package org.molsbee.movie.service;

import org.molsbee.movie.model.omdb.Search;
import org.molsbee.movie.model.omdb.TitleResponse;
import org.molsbee.movie.model.omdb.TitleSearchResponse;
import org.molsbee.movie.omdb.OmdbUri;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Log4j
public class OmdbService {

    @Autowired
    private RestTemplate restTemplate;

    public TitleResponse getMovieByTitle(String title) {
        String endpoint = OmdbUri.builder(title).build().get();
        return restTemplate.getForObject(endpoint, TitleResponse.class);
    }

    public List<TitleSearchResponse> searchMovieByTitle(String title) {
        String endpoint = OmdbUri.builder(title).search().build().get();
        Search search = restTemplate.getForObject(endpoint, Search.class);
        return search.getSearch();
    }

}
