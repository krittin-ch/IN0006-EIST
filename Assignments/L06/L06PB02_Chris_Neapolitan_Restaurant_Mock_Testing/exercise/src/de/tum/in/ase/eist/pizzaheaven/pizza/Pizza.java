package de.tum.in.ase.eist.pizzaheaven.pizza;

public abstract class Pizza {
    String name;
    boolean isBoxed;

    public void prepare() {
        System.out.println("Preparing " + name);
    }

    public void bake() {
        System.out.println("Baking " + name);
    }

    public void box(boolean isTakeaway) {
        if (isTakeaway) {
            this.isBoxed = true;
            System.out.println("Boxing " + name);
        }
    }

    public boolean isBoxed() {
        return isBoxed;
    }

    public String getName() {
        return name;
    }
}