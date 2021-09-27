package org.launchcode.birdistheword.data;

import org.launchcode.birdistheword.models.Species;
import org.springframework.data.repository.CrudRepository;

public interface SpeciesRepository extends CrudRepository<Species, Integer> {
}
