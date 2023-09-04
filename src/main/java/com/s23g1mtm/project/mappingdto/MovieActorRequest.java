package com.s23g1mtm.project.mappingdto;

import com.s23g1mtm.project.entity.Actor;
import com.s23g1mtm.project.entity.Movie;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieActorRequest {
    private Movie movie;
    private Actor actor;
}
