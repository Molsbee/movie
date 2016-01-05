package org.molsbee.movie.omdb;

import lombok.SneakyThrows;

import java.net.URLEncoder;
import java.util.Optional;

public class OmdbUri {

    private static final String OMDB_API_ENDPOINT = "http://www.omdbapi.com/";

    private final String title;
    private final String key;
    private final Type type;
    private final Optional year;
    private final Plot plot;
    private final int version;

    private OmdbUri(String title, String key, Type type, Integer year, Plot plot, int version) {
        this.title = title;
        this.key = key;
        this.type = type;
        this.year = Optional.ofNullable(year);
        this.plot = plot;
        this.version = version;
    }

    public static Builder builder(String title) {
        return new Builder(title);
    }

    @SneakyThrows
    public String get() {
        String t = "?" + key + "=" + URLEncoder.encode(this.title, "UTF-8");
        String y = "&y=" + year.orElse("");
        String p = "&plot=" + plot.name().toLowerCase();
        String dataType = "&r=json";
        String uri = OMDB_API_ENDPOINT + t + y + p + dataType;
        return uri;
    }

    public static class Builder {

        private final String title;
        private String key = "t";
        private Type type = Type.MOVIE;
        private Integer year;
        private Plot plot = Plot.SHORT;
        private int version = 1;

        public Builder(String title) {
            this.title = title;
        }

        public Builder search() {
            this.key = "s";
            return this;
        }

        public Builder imdb() {
            this.key = "i";
            return this;
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
            return new OmdbUri(title, key, type, year, plot, version);
        }

    }

}
