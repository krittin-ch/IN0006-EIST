package de.tum.in.ase.eist;

public class Instructor extends Person {
    // Constructor
    public Instructor(String name, int age, String tumId) {
        super(name, age, tumId);
    }

    // Function
    public void teach(String lectureContent) {
        say(
            String.format("Please learn \"%s\"", lectureContent)
        );        
    }
}
