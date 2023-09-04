package com.s23g1mtm.project.controller;

import com.s23g1mtm.project.entity.Actor;
import com.s23g1mtm.project.mappingdto.ActorResponse;
import com.s23g1mtm.project.service.ActorService;
import com.s23g1mtm.project.util.movieActorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actor")
public class AuthorController {
    private ActorService actorService;
    @Autowired

    public AuthorController(ActorService actorService) {
        this.actorService = actorService;
    }
    @GetMapping
    List<ActorResponse> findAll(){
        List<Actor> actors =actorService.findAll();
        return movieActorUtil.convertActorResponses(actors);
    }
    @GetMapping("/{id}")
    public ActorResponse findById(@PathVariable int id){
        Actor existsActor = actorService.findById(id);
        return movieActorUtil.convertActorResponse(existsActor);
    }


}
