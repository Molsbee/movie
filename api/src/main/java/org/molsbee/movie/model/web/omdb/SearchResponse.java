package org.molsbee.movie.model.web.omdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SearchResponse {

    @JsonProperty("Search")
    private List<SearchTitle> search;

}
