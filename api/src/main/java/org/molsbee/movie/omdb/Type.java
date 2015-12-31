package org.molsbee.movie.omdb;

public enum Type {
    MOVIE,
    SERIES,
    EPISODE, Type;

    public static Type fromString(String type) {
        Type[] types = Type.values();
        for(Type t: types) {
            if (type.equalsIgnoreCase(t.name())) {
                return t;
            }
        }
        throw new IllegalArgumentException();
    }

}
