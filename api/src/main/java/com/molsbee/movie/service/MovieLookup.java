package com.molsbee.movie.service;

import com.molsbee.movie.model.OmdbResponse;
import com.molsbee.movie.model.OmdbUri;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Log4j
public class MovieLookup {

    @Autowired
    private RestTemplate restTemplate;

    public OmdbResponse getMovieByTitle(String title) {
        String endpoint = new OmdbUri.Builder(title).build().get();
        return restTemplate.getForObject(endpoint, OmdbResponse.class);
    }

}
