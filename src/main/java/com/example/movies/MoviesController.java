package com.example.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/movies")
public class MoviesController {

    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<List<Movie>>(movieService.findAllMovies() , HttpStatus.OK);
    }

    //dynamic properties example
    @GetMapping("/imdb/{imdbId}")
    public ResponseEntity<
    Optional<Movie>> getSingleMovie(@PathVariable String imdbId) {
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);
    }
    @GetMapping("/genres/{genres}")
    public ResponseEntity <List<Movie>> getMovieByGenre(@PathVariable String genres) {
        return new ResponseEntity <List<Movie>>(movieService.findGenre(genres), HttpStatus.OK);
    }
    @GetMapping("/title/{title}")
    public ResponseEntity <List<Movie>> getMovieByTitle(@PathVariable String title) {
        return new ResponseEntity<List<Movie>>(movieService.findByTitle(title) , HttpStatus.OK);
    }
}
