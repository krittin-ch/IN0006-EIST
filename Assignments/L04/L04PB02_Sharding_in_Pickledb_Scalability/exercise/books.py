import json
import pickledb


class ShardedDatabase:
    def __init__(self):
        self.num_nodes = 10
        self.nodes = {i: pickledb.load(f"database_node_{i}.db", False) for i in range(0, 10)}
        self.store_books()

    def hash_key(self, book):
        # TODO : Hash the received key following the instructions provided
        return -1

    def store_books(self):
        for book in books:
            # Map study courses to hash-modulo keys
            node_index = self.hash_key(book)
            self.nodes[node_index].set(book, node_index)
            self.nodes[node_index].dump()


with open('books.json', 'r') as json_file:
    books_data = json.load(json_file)

# Extract books list from JSON data
books = books_data['books']

# TODO : Initiliase a class object to create Database nodes of Pickledb