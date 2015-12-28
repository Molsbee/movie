package com.molsbee.movie.model;

import lombok.SneakyThrows;

import java.net.URLEncoder;
import java.util.Optional;

public class OmdbUri {

    private final String title;
    private final Type type;
    private final Optional year;
    private final Plot plot;
    private final int version;

    private OmdbUri(String title, Type type, Integer year, Plot plot, int version) {
        this.title = title;
        this.type = type;
        this.year = Optional.ofNullable(year);
        this.plot = plot;
        this.version = version;
    }

    @SneakyThrows
    public String get() {
        String apiEndpoint = "http://www.omdbapi.com/";
        String t = "?t=" + URLEncoder.encode(this.title, "UTF-8");
        String y = "&y=" + year.orElse("");
        String p = "&plot=" + plot.name().toLowerCase();
        String dataType = "&r=json";
        String uri = apiEndpoint + t + y + p + dataType;
        return uri;
    }

    public static class Builder {

        private final String title;
        private Type type = Type.MOVIE;
        private Integer year;
        private Plot plot = Plot.FULL;
        private int version = 1;

        public Builder(String title) {
            this.title = title;
        }

        public Builder type(Type type) {
            this.type = type;
            return this;
        }

        public Builder year(int year) {
            this.year = year;
            return this;
        }

        public Builder plot(Plot plot) {
            this.plot = plot;
            return this;
        }

        public Builder version(int version) {
            this.version = version;
            return this;
        }

        public OmdbUri build() {
            return new OmdbUri(title, type, year, plot, version);
        }

    }

}
