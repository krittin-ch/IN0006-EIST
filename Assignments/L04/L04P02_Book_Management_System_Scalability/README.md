# Sharding using the Chord Consistent Hash Algorithm

We want to work with a list of books and would like to look at a complex hashing algorithm, called the Chord Consistent Hash Algorithm.

We assume you already installed python.

**You have the following tasks:**

Note: For more details on the methods, checkout the documentation of this algorithm.

1. **Implement add_node**
        
    Implement the method `add_node(self, node_id)` in the class `ChordHash`. This method adds a node containing an empty set to the dictionairy of nodes stored. Make sure that an exception is raised if the passed node ID is already used. Otherwise you might overwrite already stored values.

2. **Implement hash_key** 

    Implement the method `hash_key(self, key)` in the class `ChordHash`. This method uses the FNV hash function we already added to the class (`fnv1a_hash(key)`). Ensure the method only returns hash values fitting to the chord ring.

3. **Implement find_successor**
    Implement the method `find_successor(self, key)` in the class `ChordHash`. This method finds the node into which a key would be inserted. This is done by hashing the key (you already implemented a function for that) and then checking for a node which has the following conditions:

    - the ID of the node is larger than the hash value of the key
    - there is no other node which also has an ID larger than the hash value of the key but whose ID is smaller than the node currently considered

The successor is then the node ID. If there is no node which fullfills this (i.e. the hash value of the key is larger than all node IDs), the successor is the node with the smallest ID.

4. **Implement insert_key**
    Implement the method `insert_key(self, key)` in the class `ChordHash`. This method uses the `find_successor(self, key)` function to find the node to which the key is supposed to be added and adds the key to the set of keys stored in this node. Return the ID of the node where the key was stored.

**Verification:** Running the class creates a Chord Hash Ring, inserts the books and should print out the nodes together with the books which are mapped to each.