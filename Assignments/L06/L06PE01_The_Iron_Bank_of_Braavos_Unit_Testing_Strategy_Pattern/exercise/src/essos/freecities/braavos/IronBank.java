package essos.freecities.braavos;

import java.util.TreeMap;

public class IronBank {

    private TreeMap<String, Account> accountRepository; // Do not make final, structural tests will fail.

    // Helper methods
    // Nothing TODO here, please use these helper when implementing other methods or writing unit tests
    protected long size() {
        return accountRepository.size();
    }
    protected boolean contains(String accountName) {
        return accountRepository.containsKey(accountName);
    }

    /* Chapter 1 */
    // TODO: Question 3
    //   - Implement the following methods:
    public IronBank() {
        throw new UnsupportedOperationException("This method is not implemented.");
    }

    public void add(Account account) throws Exception {
        throw new UnsupportedOperationException("This method is not implemented.");
    }

    /* Chapter 2 */
    // TODO: Question 4
    //   - Implement the following methods:
    protected boolean isLoanEligible(Account account) {
        throw new UnsupportedOperationException("This method is not implemented.");
    }

    // TODO: Question 5
    //   - Implement the following methods:
    public long borrow(String accountName, long requestedAmount) throws Exception {
        throw new UnsupportedOperationException("This method is not implemented.");
    }

    /* Chapter 3 */
    // TODO: Question 6
    //   - Declare new instance attributes as specified in the UML diagram.
    //   - Implement the following methods:
    public void configureLoanPolicy(LoanPolicy policy) {
        throw new UnsupportedOperationException("This method is not implemented.");
    }

    protected boolean isLoanEligibleWithLoanPolicy(Account account) {
        throw new UnsupportedOperationException("This method is not implemented.");
    }

    public long borrowWithLoanPolicy(String accountName, long requestedAmount) throws Exception {
        throw new UnsupportedOperationException("This method is not implemented.");
    }
}
