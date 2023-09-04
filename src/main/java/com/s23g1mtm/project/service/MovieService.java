package com.s23g1mtm.project.service;

import com.s23g1mtm.project.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();
    Movie findById(int id);
    Movie save(Movie movie);
    Movie delete(int id);
}
