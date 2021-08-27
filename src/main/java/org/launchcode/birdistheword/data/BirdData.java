package org.launchcode.birdistheword.data;

import org.launchcode.birdistheword.models.Bird;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BirdData {

    private static Map<Integer, Bird> birds = new HashMap<>();

    public static Collection<Bird> getAll() {
        return birds.values();
    }

    public static void add (Bird bird) {
        birds.put(bird.getId(), bird);
    }

    public static Bird getById(Integer id) {
        return birds.get(id);
    }

    public static void remove(Integer id) {
        if (birds.containsKey(id)) {
            birds.remove(id);
        }
    }

}
