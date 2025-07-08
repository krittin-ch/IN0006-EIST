package essos.freecities.braavos;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestLoanPolicyAllowTrusted {

    static final private List<String> TRUSTED_NAMES =
        List.of( "Castle Black", "Casterly Rock" );

    private IronBank bank;
    private Account untrustedAccount;
    private Account trustedAccount;
    private LoanPolicy loanPolicy;

    @BeforeEach
    public void setUp() {
        this.bank = new IronBank();
        // TODO: initialize test account with non-zero loanAllowance
        this.untrustedAccount = new Account("The Iron Throne");
        this.trustedAccount = new Account("Castle Black");
        // TODO: initialize loanPolicy
        // this.loanPolicy = ... ;
        // TODO: configure bank with loanPolicy
        // this.bank.configureLoanPolicy( ... );
    }

    @AfterEach
    public void tearDown() {
        this.bank = null;
        this.untrustedAccount = null;
        this.trustedAccount = null;
        this.loanPolicy = null;
    }

    /* Chapter 4 */
    // TODO: Question 7
    //   - Initialize and Configure the loan policy in the setup() method
    //   - Change the setup() method to initialize the test account with a loanAllowance non-zero value
    //   - Add and Implement the relevant test methods below:
    //   Note: be sure to use borrowWithLoanPolicy() in the test methods
}
