package de.tum.in.ase.eist;

public class Delivery {
    public static final String ILLEGAL_DISTANCE_MESSAGE = "The input for the distance is invalid";

    private double distance;

    //TODO Task 1.3: Add the delivery strategy as an attribute, its name should be priceCalculatingAlg

    public Delivery() {
    }

    //TODO Task 1.3: Adapt the constructor to initialize the strategy
    public Delivery(double distance) {
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    // TODO Task 1.3: Implement the calculatePrice() method by using the "calculatePrice(double)" method from strategy attribute
}
