package org.launchcode.birdistheword.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Species extends AbstractEntity {

    @Size(min = 3, max = 100, message = "Species name must be between 3 and 100 characters")
    private String name;

    @OneToMany(mappedBy = "species")
    private final List<Bird> birds = new ArrayList<>();

    public Species(@Size(min = 3, max = 100, message = "Species name must be between 3 and 100 characters") String name) {
        this.name = name;
    }

    public Species() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
