package de.tum.in.ase.eist.common;

public class Event {

    public enum DietaryPreference {
        VEGAN,
        VEGETARIAN,
        OMNIVORE
    }

    private int numberOfParticipants;
    private DietaryPreference dietaryPreference;
    private String description;

    public Event() {
        numberOfParticipants = 1;
        dietaryPreference = DietaryPreference.OMNIVORE;
        description = "";
    }

    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(int numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public DietaryPreference getDietaryPreference() {
        return dietaryPreference;
    }

    public void setDietaryPreference(DietaryPreference dietaryPreference) {
        this.dietaryPreference = dietaryPreference;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
