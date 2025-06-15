# Sharding for Scalability

Sharding for Scalability and Pickled Usage in Python KV Store

In this exercise, we want to implement a simple consistent hashing protocol for every key received from a Key-Value Storage, emphasizing sharding for scalability. Sharding is a technique that involves dividing a large dataset into smaller, more manageable parts called shards, distributed across multiple nodes or servers. The primary objective is to enhance scalability and distribute the workload, leading to improved performance.

## Part 1: Install **Python** and **pickledb** (the KV Database for Python)

1. Install python version 3.12.0 if you haven't already from the official site: [Download Link](https://www.python.org/downloads/)

2. Once finished, install pickledb 0.9.2 (version >= 1.0 is incompatible): link package using pip with the following command: `pip install pickledb==0.9.2` Documentation [Documentation](https://patx.github.io/pickledb/commands.html)

- **Pickledb** is a lightweight and easy-to-use key-value database library for **Python**. It leverages Python's built-in pickle module for object serialization. The choice of **pickledb** in this context is driven by its simplicity, making it suitable for small-scale projects, educational purposes, or scenarios where a lightweight key-value store is sufficient.

## Part 2: Hashing

Now, let's talk about the hash_key function we're building. Its job is to decide which storage node should keep a book based on the book's first letter. Here's how it works:

- Node Assignment: If the first letter of the book is between `'A'` and `'C'`, we want that book to go to the first storage node. So, the function will return **0**. If it's between `'D'` and `'F'`, it goes to the second node (returning **1**), and so on (always 3 letters to the next node), until `'Y'` and `'Z'` go to node **8**.

- Handling Special Characters: For any other letter or symbol in the book title (using _isalpha()_), we've decided to send it to node **9**. This ensures all non-letter characters are treated the same way.

- For none of the above simply return **-1**.

**You have the following tasks:**

1. **Implement hash_key**
    
    Implement the method `hash_key(self, book)` in the class `ShardedDatabase`. Make sure to follow prior instructions.


    Note: The last remaining alphabets `'Y'` and `'Z'` corresponds to node 8.

## Part 3: Creating Database Nodes

To verify if the hashing was done successfully, the creation of database nodes is essential to store the books according to the Sharding concept.

**You have the following tasks:**

1. **Initialize the ShardedDatabase class**

    Create an instance of the `ShardedDatabase` class and run the entire Python class to initialize the database nodes 0-9.

    **Initialization:** Upon creating an instance of ShardedDatabase(), the _ _ init _ _ method initializes storage nodes (indexed 0 to 9) using the pickledb library.

    **Hashing and Storage:** The store_books method employs sharding logic (hash _ key), assigning books to respective storage nodes. Books are stored in a key-value format using pickledb.set.

    **Verification:** Running the class creates distinct database nodes. Books are saved based on the hashing function, with each node (database _ node _ 0.db to database _ node_9.db) handling a specific letter range. Demonstrates effective sharding for scalability.
