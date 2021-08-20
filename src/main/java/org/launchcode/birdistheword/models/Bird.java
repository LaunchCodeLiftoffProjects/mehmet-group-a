package org.launchcode.birdistheword.models;

import java.util.Date;
import java.util.Objects;

public class Bird {

//    private int id;
    private String species;
    private String behavior;
//    private Date dateSeen;

    public Bird(String species, String behavior) {
//        this.id = id;
        this.species = species;
        this.behavior = behavior;
//        this.dateSeen = dateSeen;
//        this.timeSeen = timeSeen;
    }

//    public int getId() {
//        return id;
//    }

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
//
//    public Date getDateSeen() {
//        return dateSeen;
//    }
//
//    public void setDateSeen(Date dateSeen) {
//        this.dateSeen = dateSeen;
//    }
//
//    public String getTimeSeen() {
//        return timeSeen;
//    }
//
//    public void setTimeSeen(String timeSeen) {
//        this.timeSeen = timeSeen;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Bird bird = (Bird) o;
//        return id == bird.id;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }

    @Override
    public String toString() {
        return species;
    }
}
