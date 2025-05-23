# Concurrency

In this exercise, we want to explore deadlocks using a swimming pool facility.

Here is an overview of the system: We have a `SwimmingPool`, which contains exactly one `ChangingRoom` and one `Locker` (for the sake of simplicity, a real swimming pool would obviously have more of each). Before entering the `SwimmingPool`, `Swimmer`s must change their clothes in the changing room and store their clothes in the locker. The locker should stay locked until the swimmer is done with their swimming session, and the key to the changing room should also be kept until the swimmer leaves the facility (this implies only one swimmer can be in our pool at a time). Different swimmers should be able to request entry to the swimming pool (using `goToSwimmingPool`) from multiple different threads simultaneously.

## Part 1: Create the deadlock

1. **Create the deadlock**

    Your first task is to use the mutexes provided in the `ChangingRoom` and `Locker` classes to lock and unlock the resources appropriately. Make sure to also set the new `occupant`s of the changing room and locker. Since we expect `acquireKey()` to be called before `releaseKey()` in `ChangingRoom`, the tests assume you implement them in this order (the same goes for `Locker`). We will learn later on that this will (deliberately, for this exercise) lead to a deadlock under certain conditions. Do not remove the `takeSomeTime()` calls from the methods, as they are required to (significantly) increase the likelihood of deadlocks.

    **Note:** The tests for part 2 and part 3 expect part 1 to be implemented correctly.

## Part 2: Detect the deadlock

2. **Detect the deadlock**

    We will now explore why a deadlock can occur here: Essentially, there are two valid ways to enter our (primitive) `SwimmingPool`. A `Swimmer` can choose to use the `ChangingRoom` first and store their clothes in a `Locker` afterwards or decide to use the `Locker` first (e.g. by putting their bag there, therefore “locking” this `Locker`) and use the `ChangingRoom` after that. These two options are captured in the `“SwimmingPoolActionOrder”` enum. The current `handleRequestEntry` implementation supports each `Swimmer` (thread) choosing their “preferred” order. Unfortunately, this creates an edge-case in multi-threaded scenarios, which allows a deadlock to occur when two threads use a different order and try to enter at the same time. Your task is to reproduce this deadlock scenario in the `detectDeadlock` function in `Main`.

    If you implemented task 1 correctly (i.e. you created the environment required for the deadlock to occur), then executing the main function should lead to it becoming stuck, blocking, or not terminating, as this is what deadlocks do.

    **Hint:** You will have to spawn multiple threads and create the exact interleaving that leads to the deadlock.

    **Hint:** An easy way to confirm you triggered the deadlock correctly is by not seeing `Application ended` in the console but seeing `Application started`.

## Part 3: Prevent the deadlock

3. Prevent the deadlock No results

    Finally, we want to remove the deadlock (without simply removing what we added in task 1). We can achieve this by enforcing a global order (consistent across all threads) of acquiring the `ChangingRoom` and `Locker`. This means that we will reject any entry request by a swimmer that contains an order different from our prescribed order. You may print a meaningful message to stdout when rejecting such entry requests. Make your changes to `handleEntryRequestDeadlockFree`, which currently delegates to `handleEntryRequest` in `SwimmingPool`. You may reuse as much code from `handleEntryRequest` as you see fit.

    If you implemented this part correctly, you should be able to run your main function from part 2 and see that executing it terminates now. You might have to replace the `handleEntryRequest()` call with a `handleEntryRequestDeadlockFree` call in `goToSwimmingPool` in `Swimmer` to use our updated deadlock-free implementation, depending on your implementation of part 2.