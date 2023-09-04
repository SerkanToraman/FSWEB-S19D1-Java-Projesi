package com.s23g1mtm.project.service;


import com.s23g1mtm.project.dao.MovieRepository;
import com.s23g1mtm.project.entity.Movie;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(int id) {
        Optional<Movie> movie =movieRepository.findById(id);
        if(movie.isPresent()){
            return movie.get();
        }
        return null;
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie delete(int id) {
        Movie deletedmovie=findById(id);
        movieRepository.delete(deletedmovie);
        return deletedmovie;
    }
}
