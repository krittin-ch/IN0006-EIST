package de.tum.in.ase.eist.pizzaheaven;

import de.tum.in.ase.eist.foodpalace.Employee;
import de.tum.in.ase.eist.foodpalace.ShopManager;
import org.easymock.EasyMockExtension;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(EasyMockExtension.class)
public class PizzaHeavenTest {
    private final PizzaHeaven restaurant = new PizzaHeaven();
    @Mock
    private Employee maliciousEmployee;
    @TestSubject
    private ShopManager shopManager;

    @Test
    public void testThatTheCorrectTypeOfPizzaIsCreated() {
        final var orderedPizza = restaurant.orderPizza("Margherita", true);
        // TODO check that the ordered pizza is of the type that we want
        // TODO check that we can not order a pizza that is not on the menu
        // assertThrows(NullPointerException.class, () -> );
    }

    @Test
    public void testThatTakeawayPizzasAreBoxed() {
        final var pizza = restaurant.orderPizza("Bufalina", true);
        final var unboxedPizza = restaurant.orderPizza("Bufalina", false);
        // TODO check that pizzas are boxed/unboxed
    }

    @Test
    public void infiltrateAniruddhsRestaurant() {
        // TODO change name
        expect(maliciousEmployee.getName()).andReturn("CHANGE NAME");
        // TODO prepare the mock here (don't forget to replay it)
        // TODO initialize shopManager with maliciousEmployee
        // TODO test for yourself that the mock works as expected by observing the output of the shopManager.testCurry() method
        // TODO Don't forget to verify the mock!
    }
}