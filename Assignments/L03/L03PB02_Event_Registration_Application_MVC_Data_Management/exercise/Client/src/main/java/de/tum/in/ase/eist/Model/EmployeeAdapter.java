package de.tum.in.ase.eist.Model;

import de.tum.in.ase.eist.View.Observer;
import de.tum.in.ase.eist.common.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapter extends Employee implements Observable {

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public List<Observer> getObservers() {
        return observers;
    }
}
