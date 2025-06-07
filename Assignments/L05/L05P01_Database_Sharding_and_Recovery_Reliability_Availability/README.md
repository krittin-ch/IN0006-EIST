# Database Recovery and Sharding

##prerequisites

If you have not already installed **Pickledb**, please do this with the following command:

```
pip install -r requirements.txt
```

## Part 1: Database Recovery for Reliability

### Introduction

In the first part of this exercise, you will delve into the essential concept of logging mechanisms in database management. The goal is to implement a sophisticated logging scheme using a key-value (KV) store in Python, coupled with file I/O operations. By completing this part of the exercise, you will gain practical insights into the significance of undo and redo logging in maintaining the integrity and consistency of databases.

### The KV-Store and Initial State

The KV-store represents a simplified database with key-value pairs, initiating the stable state of our database. This state remains unchanged until transactions are applied.

### The Logs: Undo and Redo

To manage changes within our KV-store, we have two types of logs:

- **Undo Log**: Records operations to reverse changes made to the KV-store, enabling a rollback to a previous state.

- **Redo Log**: Records all operations performed, allowing us to "replay" transactions and reach the state of the KV-store after the initial changes were made.

### Why do we use Undo/Redo Logging?

The primary purpose of undo/redo logging is to maintain the integrity and consistency of the database in the event of system failures. It ensures that the database can recover to a known good state after unexpected interruptions.

### Real-World Scenario

Consider a scenario where a database is handling financial transactions. If a system failure occurs during a critical transaction, undo/redo logging ensures that the database can recover without compromising the financial data's accuracy.

### How is Undo/Redo Logging Implemented?

In this exercise, you will use the provided Python script template (kv_store.py) to implement undo logging through a series of operations on a simple key-value store. The exercise was adapted and now uses lists of lists of operations to simulate multiple processes. It is similar to the exercise session, but there are more operations. The operations will only be on numerical datatypes. Here's how it's implemented:

1. **Initialize kv_store**: Understand the initial state of the key-value store.
2. **Decide on reverse operations for undo log**: Identify operations to reverse changes.
3. **Write undo log**: Generate the undo log based on the reversed operations.
4. **Apply undo log**: Simulate the recovery process by applying the undo log.
5. **Read and apply redo log**: Reapply operations using the redo log.
6. **Compare initial state and the state after the log files**: Verify that the key-value store returns to the same state as after the initial application of operations.

### Your Task

You are provided with a template file (`kv_store.py`) that includes placeholders for you to complete.

### Template Adjustments

### `kv_store.py` - Main Function

In the `main` function of `kv_store.py`, you need to complete the following steps:

- **Step 1: Log and Apply operations**
    - Utilize the `log_and_apply_operations` function to log and apply operations, considering the `redo_log_file`. Instead of a list of operations, you will get a list of lists of operations as in the real world, where you have multiple whole processes, each with multiple operations, that are logged.
- **Step 2: Apply single operations**
    - Execute the single operations in `apply_operation`, which are part of the list of operations you get in the `test_log_and_apply_operations` function. You should get the values in a string format, in order to calculate the results, you have to convert those values using the `convert_string_to_number` function. After calculating, store them in the kv-store again as strings. If there is an operation on a key that doesn't exist, first initialize it with value 0 and then apply the operation.
- **Step 3: Generate and write undo Log**
    - Reverse the order of operations and undo the changes by resetting values or deleting keys accordingly.
- **Step 4: Write undo Log**
    - Write the generated undo operations to the undo log file.
- **Step 5: Apply undo Log**
    - Utilize the `apply_log` function to apply the undo log.
- **Step 6: Apply redo Log**
    - Utilize the `apply_log` function again to apply the redo log.
- **Step 7: Comparison of initial state and the state after the log files**
    - Observe how the KV-store and the comparison KV-store are returned at the end for understanding the overall structure.
    - No further implementation is needed for this step.

- **Part 1 tests**

### Expected Outcome

By the end of the redo log application, the KV-store should precisely return to the state it was in after the initial set of operations. This showcases the robustness of undo/redo logging in preserving database integrity through transaction changes.

## Part 2: Sharding for Availability

In the second part of this exercise, we're extending the work from [L04PB02](../../L04/L04PB02_Sharding_in_Pickledb_Scalability), where we implemented the `hash_key` method and used **Pickledb** to create a sharded database.

### Part 2.1: check for keys in the sharded database

Now, given the previous implementation from [L04PB02](../../L04/L04PB02_Sharding_in_Pickledb_Scalability), we want to implement methods to check whether one or several keys are stored in the sharded database.

Methods to implement in `sharding.py`:

**You have the following tasks:**

1. **doesDBContainKey**

    This method should check whether a key is contained somewhere (i.e. in one shard) of the database. If the key is contained, the method returns `True`, otherwise `False`.

2. **doesDBContainKeys**

    This method should check whether several keys are contained somewhere (i.e. in one shard) of the database. If all keys are contained, the method returns `True`, otherwise `False`. Hint: reuse the implementation of the previous task.

3. **empty_nodes_check_remaining**

- This method should take a list of node indices (nodes_to_empty).
- First you store the values previously stored in the database, distinguishing between whether they are supposed to be deleted or not
- Second you kill the respective nodes from the db (Use the provided methods `empty_nodes()`/`empty_node()`)
- Third, you check that the database no longer contains the elements of the killed nodes but still contains the elements of those that have not been killed. If this does not hold, raise an exception with the given message (Use `doesDBContainKeys()`)
- Finally return the two lists of values (one which contains the elements still available, one which contains the elements deleted through killing the nodes)

As you see, sharding leads to an increase in availability, simply because killing some nodes does not necessarily lead to all data being unavailable. Instead, a certain amount of data is still available. To ensure a very low chance of data loss, one would store each key in several nodes, so it is unlikely all nodes die at the same time.

### Part 2.2: node replication for data recovery

In part 2 of the second part of this exercise, you will implement functionality to recover lost data by creating replicas and then using these replicas for data recovery. This ensures data integrity and availability in the sharded database.

Methods to implement:

**You have the following tasks:**

1. **create_replicates**

    Implement this method to create replica nodes for all nodes in the sharded database. This method should return the replicated nodes after the replication process is complete.

2. **recover_node**

    Implement this method to recover lost (deleted) data in the sharded database. It should take a node_index as a parameter, copy the replica of the node to the actual sharded database, and return the recovered node.

3. **recover_nodes**

    Implement this method to recover multiple nodes. It should take a list of node_index values, perform the recovery for each node using the `recover_node()` method, and return the list of recovered nodes.

By implementing node replication, you will enable the sharded database to recover lost data, thereby enhancing its reliability and resilience.

## Conclusion

During the first part of the exercise, you have implemented undo and redo logging, which is beneficial to the **reliability** and **resilience** of a database system. In the second part of the exercise, you first extended a sharded database implementation, which is important for the **availability** and then implemented node replication for this sharded database, which even further improved its **availability**. These concepts are crucial for real-world applications to guarantee database integrity.