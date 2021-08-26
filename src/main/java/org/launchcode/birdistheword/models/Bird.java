package org.launchcode.birdistheword.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Entity
public class Bird {

    @Id
    @GeneratedValue
    private int id;

    @NotNull(message = "Species required.")
    @Size(max = 255, message = "255 characters or fewer needed")
    private String species;

    @NotNull(message = "Behavior required.")
    @Size(max = 255, message = "255 characters or fewer needed")
    private String behavior;

    @NotNull(message = "Date required.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateSeen;

    public Bird(){

    }

    public Bird(String species, String behavior, Date dateSeen) {
        this.species = species;
        this.behavior = behavior;
        this.dateSeen = dateSeen;
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

    public Date getDateSeen() {
        return dateSeen;
    }

    public void setDateSeen(Date dateSeen) {
        this.dateSeen = dateSeen;
    }
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
