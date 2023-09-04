package com.s23g1mtm.project.dao;

import com.s23g1mtm.project.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
