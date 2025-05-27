package de.tum.in.ase.eist.Controller;

import de.tum.in.ase.eist.Model.EmployeeAdapter;
import de.tum.in.ase.eist.Model.EventAdapter;
import de.tum.in.ase.eist.View.EmployeeCreationView;
import de.tum.in.ase.eist.View.EventListView;
import de.tum.in.ase.eist.View.EventRegistrationView;

public class Controller {
    private EventListView eventListView;
    private EventRegistrationView eventRegistrationView;
    private EmployeeCreationView employeeCreationView;

    public void displayEvent(EventAdapter event) {
        this.eventRegistrationView = new EventRegistrationView(this, event);
        this.eventRegistrationView.show();
    }

    public void setEventListView(EventListView eventListView) {
        this.eventListView = eventListView;
    }

    public void setEventRegistrationView(EventRegistrationView eventRegistrationView) {
        this.eventRegistrationView = eventRegistrationView;
    }

    public void saveEvent(EventAdapter event) {
        this.eventListView.saveEvent(event);
        event.notifyObservers();
    }

    // TODO: Implement addNewEmployee(...). Add the employee to the eventRegistrationView and then notify all of its observers
    public void addNewEmployee(EmployeeAdapter employee) {
    }

    public void displayEmployee(EmployeeAdapter employee) {
        this.employeeCreationView = new EmployeeCreationView(this, employee);
        this.employeeCreationView.show();
    }
}
