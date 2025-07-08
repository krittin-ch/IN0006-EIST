package essos.freecities.braavos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestIronBank {

    private IronBank bank;
    private Account account;

    @BeforeEach
    void setUp() {
        bank = new IronBank();
        account = new Account("Tywin Lannister");
    }

    @AfterEach
    public void tearDown() {
        this.bank = null;
        this.account = null;
    }

    @Test
    void testBankEmpty() {
        // Dummy test - Not graded - Shown for completeness of the test coverage
        assertTrue(true);
    }

    /* Chapter 1 */
    // TODO: Question 2
    //   - Implement the following test methods:
    @Test
    void testAddAbsent() {
        throw new UnsupportedOperationException("This test is not implemented.");
    }

    @Test
    void testAddPresent() {
        throw new UnsupportedOperationException("This test is not implemented.");
    }

    /* Chapter 2 */
    // TODO: Question 4
    //   - Change the setup() method to initialize the test account with a non-zero loanAllowance value
    //   - Implement the following test methods:
    @Test
    void testIsLoanEligible() {
        throw new UnsupportedOperationException("This test is not implemented.");
    }

    @Test
    void testIsNotLoanEligible() {
        throw new UnsupportedOperationException("This test is not implemented.");
    }

    // TODO: Question 5
    //   - Implement the following test methods:
    @Test
    public void testBorrowNotInIronBank() {
        throw new UnsupportedOperationException("This test is not implemented.");
    }

    @Test
    public void testBorrowNotLoanEligible() {
        throw new UnsupportedOperationException("This test is not implemented.");
    }

    @Test
    public void testBorrowProperAmount() {
        throw new UnsupportedOperationException("This test is not implemented.");
    }

    @Test
    public void testBorrowProperAmountLessThanAmount() {
        throw new UnsupportedOperationException("This test is not implemented.");
    }
}
