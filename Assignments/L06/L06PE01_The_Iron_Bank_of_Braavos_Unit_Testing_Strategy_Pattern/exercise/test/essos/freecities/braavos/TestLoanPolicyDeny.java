package essos.freecities.braavos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestLoanPolicyDeny {

    private IronBank bank;
    private Account account;
    private LoanPolicy loanPolicy;

    @BeforeEach
    public void setUp() {
        this.bank = new IronBank();
        // TODO: initialize test account with non-zero loanAllowance
        this.account = new Account("Petyr Baelish");
        // TODO: initialize loanPolicy
        // this.loanPolicy = ... ;
        // TODO: configure bank with loanPolicy
        // this.bank.configureLoanPolicy( ... );
    }

    @AfterEach
    public void tearDown() {
        this.bank = null;
        this.account = null;
        this.loanPolicy = null;
    }

    /* Chapter 3 */
    // TODO: Question 6
    //   - Initialize and Configure the loan policy in the setup() method
    //   - Change the setup() method to initialize the test account with a loanAllowance non-zero value
    //   - Add and Implement the relevant test methods below:
    //   Note: be sure to use borrowWithLoanPolicy() in the test methods
}
