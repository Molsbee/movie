package com.molsbee.movie.model.omdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Search {

    @JsonProperty("Search")
    private List<TitleSearchResponse> search;

}
