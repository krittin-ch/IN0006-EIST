package de.tum.in.ase.eist.Model;

import de.tum.in.ase.eist.View.Observer;

import java.util.List;

public interface Observable {

    List<Observer> getObservers();

    default void notifyObservers() {
        for (Observer observer : getObservers()) {
            observer.update();
        }
    }

    default void addObserver(Observer observer) {
        getObservers().add(observer);
    }

    default void removeObserver(Observer observer) {
        getObservers().remove(observer);
    }
}