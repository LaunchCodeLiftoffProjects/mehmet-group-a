package org.launchcode.birdistheword.data;

import org.launchcode.birdistheword.models.Bird;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BirdRepository extends CrudRepository<Bird, Integer> {
}
