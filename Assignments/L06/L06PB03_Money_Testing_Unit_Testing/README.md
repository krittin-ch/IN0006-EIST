# Unit Tests

In this exercise, we want to implement unit tests for the `Money` class. Clone the repository and import the `Gradle` project into your IDE.

**You have the following tasks:**

1. Complete the implementation of the Money class 
    
    Implement the method `subtract(Money)` in the class `Money`. Implement the precondition for `add(...)` and `subtract(...)` that the currency must be identical. Throw an `IllegalArgumentException` if this is not the case.

2. **Test the add() method** 

    Implement the assertion in `testSimpleAdd()` in `MoneyTest`.

3. **Test the subtract() method** 
    
    Implement `testSimpleSubtract()` in `MoneyTest`.

4. **Test that add() throws an exception for currency mismatches** 

    Implement `testInvalidAdd()` in `MoneyTest` by expecting an `IllegalArgumentException` when the two currencies are different.
