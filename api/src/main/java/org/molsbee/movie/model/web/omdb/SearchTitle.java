package org.molsbee.movie.model.web.omdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SearchTitle {

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private String year;

    @JsonProperty("imdbID")
    private String imdbId;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("Poster")
    private String poster;

}
