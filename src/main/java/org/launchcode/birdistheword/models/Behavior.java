package org.launchcode.birdistheword.models;

public enum Behavior {
    EATING("Eating at a feeder"),
    SWIMMING("Swimming or wading"),
    GROUND("On the ground"),
    TREES("In trees or bushes"),
    FENCE("On a fence or wire"),
    SOARING("Soaring or flying");

    private final String displayName;

    Behavior(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
