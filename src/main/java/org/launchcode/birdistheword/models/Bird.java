package org.launchcode.birdistheword.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

public class Bird {

    private int id;
    private static int nextId = 1;

    @NotBlank(message = "Species is required")
    @Size(min = 3, max = 100, message = "Species name must be between 3 and 100 characters")
    private String species;

    @NotBlank(message = "Behavior is required")
    @Size(max = 200, message = "Behavior description is too long")
    private String behavior;

    private String dateSeen;

    public Bird(String species, String behavior, String dateSeen) {
        this();
        this.species = species;
        this.behavior = behavior;
        this.dateSeen = dateSeen;
    }

    public Bird() {
        this.id = nextId;
        nextId++;
    }

    public int getId() {
        return id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
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
