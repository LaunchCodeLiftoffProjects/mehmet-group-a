package org.launchcode.birdistheword.repository;

import org.launchcode.birdistheword.models.Bird;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BirdRepo extends CrudRepository<Bird, Integer> {
}

