package com.s23g1mtm.project.service;

import com.s23g1mtm.project.dao.ActorRepository;
import com.s23g1mtm.project.entity.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ActorServiceImpl implements ActorService {
    private ActorRepository actorRepository;
    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Override
    public Actor findById(int id) {
        Optional<Actor> actor = actorRepository.findById(id);
        if(actor.isPresent()){
            return actor.get();
        }
       return null;
    }

    @Override
    public Actor save(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public Actor delete(int id) {
        Actor deletedActor = findById(id);
        actorRepository.delete(deletedActor);
        return deletedActor;
    }
}
