package de.tum.in.ase.eist.pizzaheaven;

import de.tum.in.ase.eist.pizzaheaven.pizza.Bufalina;
import de.tum.in.ase.eist.pizzaheaven.pizza.Margherita;
import de.tum.in.ase.eist.pizzaheaven.pizza.Pizza;

public class PizzaHeaven extends Baker {
    @Override
    public Pizza createPizza(String type) {
        if (type.equals("Margherita")) {
            return new Margherita();
        } else if (type.equals("Bufalina")) {
            return new Bufalina();
        } else {
            return null;
        }
    }
}
