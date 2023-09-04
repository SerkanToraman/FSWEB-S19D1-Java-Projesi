package com.s23g1mtm.project.controller;

import com.s23g1mtm.project.entity.Actor;
import com.s23g1mtm.project.entity.Movie;
import com.s23g1mtm.project.mappingdto.ActorResponse;
import com.s23g1mtm.project.mappingdto.MovieActorRequest;
import com.s23g1mtm.project.mappingdto.MovieActorResponse;
import com.s23g1mtm.project.mappingdto.MovieResponse;
import com.s23g1mtm.project.service.MovieService;
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
        List<MovieResponse> movieResponses = new ArrayList<>();
        List<Movie> movies = movieService.findAll();
        for(Movie movie : movies){
            movieResponses.add(new MovieResponse(movie.getId(), movie.getName(), movie.getDirectorName(), movie.getRating(), movie.getReleaseDate()));
        }
        return movieResponses;
    }

    @GetMapping("/{id}")
    public MovieResponse findById(@PathVariable int id){
        Movie existsMovie = movieService.findById(id);
        return new MovieResponse(existsMovie.getId(),existsMovie.getName(),existsMovie.getDirectorName(),existsMovie.getRating(),existsMovie.getReleaseDate());
    }
    @PostMapping("/")
    public MovieActorResponse save(@RequestBody MovieActorRequest movieActorRequest){
        Movie movie = movieActorRequest.getMovie();
        Actor actor = movieActorRequest.getActor();
        movie.addActor(actor);
        Movie savedMovie = movieService.save(movie);
        return new MovieActorResponse(savedMovie,actor.getId(), actor.getFirstName(), actor.getLastName(), actor.getBirthDate());
    }
    @PostMapping("/addActors/{movieId}")
    public List<ActorResponse> addActor(@RequestBody List<Actor> actors, @PathVariable int movieId){
        Movie existingMovie = movieService.findById(movieId);
        existingMovie.addAllActors(actors);
        Movie savedMovie =movieService.save(existingMovie);
        List<ActorResponse> actorResponses = new ArrayList<>();
        for (Actor actor : savedMovie.getActors()) {
            actorResponses.add(new ActorResponse(actor.getId(), actor.getFirstName(), actor.getLastName(),
                    actor.getBirthDate()));
        }
        return actorResponses;
    }
    @PutMapping("/{id}")
    public MovieResponse update(@RequestBody Movie movie,@PathVariable int id){
        Movie existingMovie =movieService.findById(id);
        movie.setId(id);
        movie.setActors(existingMovie.getActors());
        Movie updatedMovie = movieService.save(movie);
        return new MovieResponse(movie.getId(), movie.getName(), movie.getDirectorName(),
                movie.getRating(), movie.getReleaseDate());
    }
    @DeleteMapping("/{id}")
    public MovieResponse delete(@PathVariable int id) {
        Movie movie = movieService.delete(id);
        return new MovieResponse(movie.getId(), movie.getName(), movie.getDirectorName(),
                movie.getRating(), movie.getReleaseDate());
    }

}
