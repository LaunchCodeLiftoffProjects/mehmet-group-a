package org.launchcode.birdistheword.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Entity
public class Bird {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "Species is required")
    @Size(min = 3, max = 100, message = "Species name must be between 3 and 100 characters")
    private String species;

    private Behavior behavior;

    private String dateSeen;

    public Bird(String species, Behavior behavior, String dateSeen) {
        this.species = species;
        this.behavior = behavior;
        this.dateSeen = dateSeen;
    }

    public Bird() { }

    public int getId() {
        return id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bird bird = (Bird) o;
        return id == bird.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return species;
    }
}
