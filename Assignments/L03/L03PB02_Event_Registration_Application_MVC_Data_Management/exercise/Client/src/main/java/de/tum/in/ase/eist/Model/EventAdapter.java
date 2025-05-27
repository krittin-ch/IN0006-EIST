package de.tum.in.ase.eist.Model;

import de.tum.in.ase.eist.View.Observer;
import de.tum.in.ase.eist.common.Event;

import java.util.ArrayList;
import java.util.List;

public class EventAdapter extends Event implements Observable {

    private final List<Observer> observers = new ArrayList<>();

    private final List<EmployeeAdapter> employees = new ArrayList<>();

    @Override
    public List<Observer> getObservers() {
        return observers;
    }

    public List<EmployeeAdapter> getEmployees() {
        return employees;
    }
}
