package de.tum.in.ase.eist;

import de.tum.in.ase.eist.banking.BankAccountController;
import de.tum.in.ase.eist.banking.TransactionController;

public class Client {

    // TODO 2 remove all associations to the different controllers in class Client use the facade instead.
    private final String cardHolder;
    private String cardNumber;
    private String pinCode;
    private double balance;

    private final TransactionController transactionController;
    private final BankAccountController bankAccountController;

    public Client(String cardHolder, double initialBalance) {
        this.cardHolder = cardHolder;
        this.balance = initialBalance;
        this.transactionController = new TransactionController();
        this.bankAccountController = new BankAccountController();
    }

    public void depositCash(String pinCode, double cash) {
        if (!bankAccountController.authenticate(this, pinCode)) {
            System.out.println("Incorrect PIN Code. Access denied.");
        } else if (cash <= 0) {
            System.out.println("Bad request!");
        } else {
            transactionController.depositCash(this, cash);
            System.out.println("Deposit of $" + cash + " completed. " +
                    "Your current balance: " + this.getBalance());
        }
    }

    public void withdrawCash(String pinCode, double cash) {
        if (!bankAccountController.authenticate(this, pinCode)) {
            System.out.println("Incorrect PIN Code. Access denied.");
        } else if (this.getBalance() < cash) {
            System.out.println("Bad request!");
        } else {
            transactionController.withdrawCash(this, cash);
            System.out.println("Withdraw of $" + cash + " completed. " +
                    "Your current balance: " + this.getBalance());
        }
    }

    public void openBankAccount() {
        bankAccountController.openBankAccount(this);
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double initialBalance) {
        this.balance = initialBalance;
    }

    public String getPinCode(){
        return this.pinCode;
    }

    public final void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}

