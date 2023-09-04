package com.s23g1mtm.project.controller;

import com.s23g1mtm.project.entity.Actor;
import com.s23g1mtm.project.entity.Movie;
import com.s23g1mtm.project.mappingdto.ActorResponse;
import com.s23g1mtm.project.mappingdto.MovieActorRequest;
import com.s23g1mtm.project.mappingdto.MovieActorResponse;
import com.s23g1mtm.project.mappingdto.MovieResponse;
import com.s23g1mtm.project.service.MovieService;
import com.s23g1mtm.project.util.movieActorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Repeatable;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private MovieService movieService;
    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public List<MovieResponse> findAll(){
        List<Movie> movies = movieService.findAll();
        return movieActorUtil.convertMovieResponses(movies);
    }
    @GetMapping("/{id}")
    public MovieResponse findById(@PathVariable int id){
        Movie existsMovie = movieService.findById(id);
        return movieActorUtil.convertMovieResponse(existsMovie);
    }
    @PostMapping("/")
    public MovieActorResponse save(@RequestBody MovieActorRequest movieActorRequest){
        Movie movie = movieActorRequest.getMovie();
        Actor actor = movieActorRequest.getActor();
        movie.addActor(actor);
        Movie savedMovie = movieService.save(movie);
        return movieActorUtil.convertMovieActorResponse(savedMovie,actor);
    }
    @PostMapping("/addActors/{movieId}")
    public List<ActorResponse> addActor(@RequestBody List<Actor> actors, @PathVariable int movieId){
        Movie existingMovie = movieService.findById(movieId);
        existingMovie.addAllActors(actors);
        Movie savedMovie =movieService.save(existingMovie);
        return movieActorUtil.convertActorResponses(savedMovie);

    }
    @PutMapping("/{id}")
    public MovieResponse update(@RequestBody Movie movie,@PathVariable int id){
        Movie existingMovie =movieService.findById(id);
        movie.setId(id);
        movie.setActors(existingMovie.getActors());
        Movie updatedMovie = movieService.save(movie);
        return movieActorUtil.convertMovieResponse(updatedMovie);
    }
    @DeleteMapping("/{id}")
    public MovieResponse delete(@PathVariable int id) {
        Movie deletedMovie = movieService.delete(id);
        return movieActorUtil.convertMovieResponse(deletedMovie);

    }

}
