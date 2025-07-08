package essos.freecities.braavos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestAccount {

    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account("Tywin Lannister");
    }

    @AfterEach
    public void tearDown() {
        this.account = null;
    }

    @Test
    void testGetName() {
        // Dummy test - Not graded - Shown for completeness of the test coverage
        assertTrue(true);
    }

    /* Chapter 1 */
    // TODO: Question 1
    //   - Implement the following test methods:
    @Test
    void testBalanceZero() {
        throw new UnsupportedOperationException("This test is not implemented.");
    }

    @Test
    void testBalanceNonZero() {
        throw new UnsupportedOperationException("This test is not implemented.");
    }
}
