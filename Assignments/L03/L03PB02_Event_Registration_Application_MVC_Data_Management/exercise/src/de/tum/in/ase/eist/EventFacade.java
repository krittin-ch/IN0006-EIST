package de.tum.in.ase.eist;

import de.tum.in.ase.eist.common.Employee;
import de.tum.in.ase.eist.common.Event;

public class EventFacade {

    private EventClient eventClient;
    private TokenGeneratorClient tokenGeneratorClient;

    public EventFacade() {
        eventClient = new EventClient();
        tokenGeneratorClient = new TokenGeneratorClient();
    }

    //TODO: Finish the implementation of the registerEvent() method.
    public void registerEvent(Employee employee) {
        try {
            if (employee.getRole() == Employee.Role.MANAGER) {
                //TODO: generate and set token
                try {
                    String registrationResponse = "";
                    //TODO: register the event in the eventClient
                    if (registrationResponse.equals("Registration is successful")) {
                        //TODO: Employee registered status should be set to true
                    } else {
                        System.out.println("Registration failed");
                    }
                } catch (Exception e) {

                }
            } else {
                //TODO: print "Only managers can register the event!"
                System.out.println("");
            }
        } catch (Exception e) {

        }
    }

    public void sendPreferences(Employee employee, Event event) {
        if (employee.getIsRegistered()) {
            employee.setEventPreferences(event);
            eventClient.recordPreferences(employee);
        } else {
            System.out.println("Employee should register to the event first!");
        }

    }

    public EventClient getEventClient() {
        return eventClient;
    }

    public void setEventClient(EventClient eventClient) {
        this.eventClient = eventClient;
    }

    public TokenGeneratorClient getTokenGeneratorClient() {
        return tokenGeneratorClient;
    }

    public void setTokenGeneratorClient(TokenGeneratorClient tokenGeneratorClient) {
        this.tokenGeneratorClient = tokenGeneratorClient;
    }
}
