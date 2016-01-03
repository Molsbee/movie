insert into service_accounts(username, password, enabled) values ('william.molsbee', 'testing', 1);
insert into account_authorities(id, username, authority) values (1, 'william.molsbee', 'ADMIN');
insert into account_authorities(id, username, authority) values (2, 'william.molsbee', 'USER');

insert into actor(id, first_name, last_name) values (1, 'Ryan', 'Reynolds');
insert into actor(id, first_name, last_name) values (2, 'Blake', 'Lively')

insert into genre(id, genre_name) values (1, 'Sci-Fi');
insert into genre(id, genre_name) values (2, 'Action');
insert into genre(id, genre_name) values (3, 'Adventure');

insert into movie(id, title, year, rating, release_date, runtime, director, writer, plot, language, country, awards, poster, metascore, imdbRating, imdbVotes, imdbId, type) values (1, 'Green Lantern', '2011', 'PG-13', '17 Jun 2011', '114 min', 'Martin Campbell', 'Greg Berlanti', 'Reckless', 'English', 'USA', '1 win & 5 nominations', 'http://ia.media-imdb.com/images/M/MV5BMTMyMTg3OTM5Ml5BMl5BanBnXkFtZTcwNzczMjEyNQ@@._V1_SX300.jpg', '39', '5.7', '197161', 'tt1133985', 'MOVIE');

insert into movie_actors values (1, 1);
insert into movie_actors values (1, 2);

insert into movie_genres values (1, 1);
insert into movie_genres values (1, 2);
insert into movie_genres values (1, 3);