package com.example.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    //uses repo class to talk to database
    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }
    public Optional<Movie> singleMovie(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }

    public List<Movie> findGenre(String genres) {
        return movieRepository.findByGenre(genres);
    }

    public List<Movie> findByTitle(String title) {
        return movieRepository.findByTitle(title);
    }
}
