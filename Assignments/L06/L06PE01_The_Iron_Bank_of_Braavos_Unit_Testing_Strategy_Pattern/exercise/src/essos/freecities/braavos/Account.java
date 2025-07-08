package essos.freecities.braavos;

public class Account {

    /* Chapter 1 */
    // Nothing TODO here yet, come back later for Chapter 2
    private String name; // Do not make name final, structural tests will fail.
    private long balance;

    public Account(String name) {
        this.name = name;
        this.balance = 0;
    }

    /* Chapter 2 */
    // TODO: Question 4
    //   - Declare new instance attributes as specified in the UML diagram.
    //   - Implement the following methods:
    public Account(String name, long loanAllowance) {
        throw new UnsupportedOperationException("This method is not implemented.");
    }

    public String getName() {
        return name;
    }

    public void setBalance(long newBalance) {
        this.balance = newBalance;
    }

    public long getBalance() {
        return balance;
    }

    public long getLoanAllowance() {
        throw new UnsupportedOperationException("This method is not implemented.");
    }
}
