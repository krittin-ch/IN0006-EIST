package de.tum.in.ase.eist.Model;

// Sequential log of all Transactions
// Must implement the following methods:
// - insertTransaction(Transaction transaction): boolean
// - begin(): Transaction
// - next(Transaction transaction): Transaction
//
// DO NOT CHANGE THE EXISTING METHOD SIGNATURES
// Add any fields you like
// You may add private helper methods
public class TransactionLog {
    // Add fields here
    //
	// Constructor
	// TODO L03P02 Model 1.1:Implement the Constructor in TransactionLog

	public TransactionLog() {
	}

    // Append a Transaction to the TransactionLog
    // Returns true when succesful
	// TODO L03P02 Model 1.2: Implement the insertTransaction method in TransactionLog
	public boolean insertTransaction(Transaction transaction) {
        return false;
	}

    // Returns the first Transaction in the TransactionLog
	// TODO L03P02 Model 1.3: Implement the begin method in TransactionLog
	public Transaction begin() {
		return null;
	}

    // Given a Transaction, returns the next Transaction in the TransactionLog
    // Returns null if the given Transaction is not in the TransactionLog
    // Returns null if there is no succeeding Transaction
	// TODO L03P02 Model 1.4: Implement the next method in TransactionLog
	public Transaction next(Transaction transaction) {
        return null;
	}

}
