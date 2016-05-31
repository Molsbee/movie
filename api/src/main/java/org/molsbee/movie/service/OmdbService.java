package org.molsbee.movie.service;

import lombok.extern.log4j.Log4j;
import org.molsbee.movie.model.web.omdb.SearchResponse;
import org.molsbee.movie.model.web.omdb.TitleResponse;
import org.molsbee.movie.model.web.omdb.SearchTitle;
import org.molsbee.movie.omdb.OmdbUri;
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

    public List<SearchTitle> searchMovieByTitle(String title) {
        String endpoint = OmdbUri.builder(title).search().build().get();
        SearchResponse search = restTemplate.getForObject(endpoint, SearchResponse.class);
        return search.getSearch();
    }

}
