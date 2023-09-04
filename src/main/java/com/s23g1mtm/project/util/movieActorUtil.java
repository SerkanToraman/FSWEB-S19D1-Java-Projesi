package com.s23g1mtm.project.util;

import com.s23g1mtm.project.entity.Actor;
import com.s23g1mtm.project.entity.Movie;
import com.s23g1mtm.project.mappingdto.ActorResponse;
import com.s23g1mtm.project.mappingdto.MovieActorResponse;
import com.s23g1mtm.project.mappingdto.MovieResponse;

import java.util.ArrayList;
import java.util.List;

public class movieActorUtil {
    public static MovieActorResponse convertMovieActorResponse(Movie movie, Actor actor) {
        return new MovieActorResponse(movie, actor.getId(), actor.getFirstName(),
                actor.getLastName(), actor.getBirthDate());
    }
    public static List<ActorResponse> convertActorResponses(Movie savedMovie){
        List<ActorResponse> actorResponses = new ArrayList<>();
        for (Actor actor : savedMovie.getActors()) {
            actorResponses.add(new ActorResponse(actor.getId(), actor.getFirstName(), actor.getLastName(),
                    actor.getBirthDate()));
        }
        return actorResponses;
    }
    public static MovieResponse convertMovieResponse(Movie movie){
        return new MovieResponse(movie.getId(), movie.getName(), movie.getDirectorName(),
                movie.getRating(), movie.getReleaseDate());
    }
    public static List<MovieResponse> convertMovieResponses(List<Movie> movies){
        List<MovieResponse> movieResponses = new ArrayList<>();
        for(Movie movie : movies){
            movieResponses.add(new MovieResponse(movie.getId(), movie.getName(), movie.getDirectorName(), movie.getRating(), movie.getReleaseDate()));
        }
        return movieResponses;
    }
    public static List<ActorResponse> convertActorResponses(List<Actor> actors){
        List<ActorResponse> actorResponses = new ArrayList<>();
        for(Actor actor : actors){
            actorResponses.add(new ActorResponse(actor.getId(),actor.getFirstName(),actor.getLastName(),actor.getBirthDate()));
        }
        return actorResponses;
    }
    public static ActorResponse convertActorResponse(Actor actor){
        return new ActorResponse(actor.getId(),actor.getFirstName(),actor.getLastName(),actor.getBirthDate());
    }
}
