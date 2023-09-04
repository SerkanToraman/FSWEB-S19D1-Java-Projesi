package com.s23g1mtm.project.service;

import com.s23g1mtm.project.entity.Actor;

import java.util.List;

public interface ActorService {
    List<Actor> findAll();
    Actor findById(int id);
    Actor save(Actor actor);
    Actor delete(int id);
}
