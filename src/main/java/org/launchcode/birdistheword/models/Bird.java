package org.launchcode.birdistheword.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Bird extends AbstractEntity {

    @ManyToOne
    private Species species;

    private Behavior behavior;

    private String dateSeen;

    public Bird(Species species, Behavior behavior, String dateSeen) {
        this.species = species;
        this.behavior = behavior;
        this.dateSeen = dateSeen;
    }

    public Bird() { }


    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public Behavior getBehavior() {
        return behavior;
    }

    public void setBehavior(Behavior behavior) {
        this.behavior = behavior;
    }

    public String getDateSeen() {
        return dateSeen;
    }

    public void setDateSeen(String dateSeen) {
        this.dateSeen = dateSeen;
    }

    @Override
    public String toString() {
        return species.getName();
    }
}
