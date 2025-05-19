package de.tum.in.ase.eist;

public class EventFacade {

    EventClient eventClient;
    TokenGeneratorClient tokenGeneratorClient;

    //TODO L03P01 Facade Pattern 1.1: Implement the Constructor and initialize all attributes.
    public EventFacade() {
    }

    //TODO L03P01 Facade Pattern 1.2: Implement the registerEvent method.
    public void registerEvent(Employee employee) {
    }

    //TODO L03P01 Facade Pattern 1.3: Implement the sendPreferences method.
    public void sendPreferences(Employee employee, Event event) {
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
