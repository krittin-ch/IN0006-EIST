# Model View Controller with Database

We are very excited to announce our latest project, Shopingu, a special shopping site for the penguins we know from last semester. Currently we are in the final stages of implementation. We are focusing on creating a seamless shopping experience using the Model View Controller (MVC) architecture with JavaFX for the View. The goal is to provide a synchronized and efficient shopping process by creating an intuitive platform to list and organize products. Join us in creating a delightful online shopping destination for our cute, furry customers!

Clone the project and import it to your IDE as `Gradle Project`.

To try out your application locally, just run the `main`-method in `ShopMain`.

## Part 1: Model

First, we need to implement `Model` components. The model includes the observable `Product`, a Data Access Object `ProductDAO` for accessing the database without any business logic, and the `DatabaseHelper` class that implements the connection to and the querying of the SQLite database.

## DatabaseHelper

1. **Implement updateProduct() in the DatabaseHelper**

    Implement the method `updateProduct()` in the class `DatabaseHelper`. The method should execute an update on the database based on the given product parameter. [SQLite Update Tutorial](https://www.sqlitetutorial.net/sqlite-update/)

    1. To achieve that, create a prepared SQL statement that updates the `PRODUCT_TABLE` table row that has the id of the given product parameter. The statement should update all the table columns, ie. name, description, price, and stored quantity.
    2. Using other methods as an example of how to connect to the database and create the `PreparedStatement` object, fill the SQL prepared statement placeholder values with the values of the given product object.
    3. Execute the update using the `executeUpdate()` method of the `PreparedStatement` object.
    4. The return value of the `executeUpdate()` method specifies how many rows were updated during the statement execution. Check that value is equal to one. If it is, use the `selectProductById()` method of the class with the id of the product that was just updated to return the final saved product. Otherwise, print to `stderr` the message `Something went wrong updating product with id` and return `null`.

    If an `SQLException` occurs anywhere in the method, print the message of the exception to `stderr` and return `null`.

## ProductDAO

1. **Implement saveProduct() in the ProductDAO**

    Implement the method `saveProduct()` in the class `ProductDAO`. This method calls the `insertProduct()` method of the `DatabaseHelper` with the given parameter and returns its return value. Inserting a product will ignore the product id and the database will assign it a new one.

2. **Implement updateProduct() in the ProductDAO** 

    Implement the method `updateProduct()` in the class `ProductDAO`. This method calls the `updateProduct()` method of the `DatabaseHelper` with the given parameter and returns its return value.

3. **Implement selectProducts() in the ProductDAO** 

    Implement the method `selectProducts()` in the class `ProductDAO`. This method calls the `selectAllProducts()` method of the `DatabaseHelper` and returns its return value.

4. **Implement deleteProduct() in the ProductDAO** 

    Implement the method `deleteProduct()` in the class `ProductDAO`. This method calls the `deleteProduct()` method of the `DatabaseHelper` with the given parameter and returns its return value.

## Part 2: Controller

The next step is to implement the Controller and handle interactions with the database.

1. **Implement buyProduct() in the Controller**

    Implement the method `buyProduct()` in the class `Controller`. This method should validate if the stored quantity of the product is sufficient for the purchase.

    - If the quantity is enough, decrement the stored quantity, update the product using the `productDAO` attribute, and notify observers.
    - If the quantity is insufficient, throw an exception with the message "Insufficient stock. Purchase not successful. `<product stored quantity>` left."
    - If the quantity is 0, throw an exception with the message "Insufficient stock. Purchase not successful."

2. **Finish implementation of saveProduct() in the Controller** 
    
    Finish the implementation of the `saveProduct()` method in the class `Controller`. This method should handle the insertion of a new product into the database or the update of an existing one.

    - If the given product has an id of -1, it should be treated as a new product and inserted into the database. If the id is not -1, check if the product already exists in the database:
    - If the product exists, update the product with the given product. Use the already implemented function `selectProductById` in `ProductDAO` to check if the product exists.
    - If the product does not already exist in the database, consider it as a new product with an id of -1. Proceed to save the product using the saveProduct() method of the class `ProductDAO`. This method will return the id of the newly inserted product. Create and return a new object with identical attributes to the non-existent product, but with the updated id obtained from the `ProductDAO`.
    - If the views exist, add the saved product to the views. You should add the product to the admin view first, and then later to the customer view.

## Part 3: View

Now, we will bring it all together by implementing the final methods in the view classes.

1. **Implement deleteProduct() in AdminView** 
    
    Implement the method `deleteProduct()` in AdminView. This method is used to delete a product from the database.

2. **Implement addProduct() in ParentView** 

    Implement the `addProduct()` method in ParentView. The `addProduct` method adds a new product to the `products` list, and it also ensures that if a product with the same ID already exists in the list, it is replaced.

3. **Implement update() in ParentView** 

    Implement the `update()` method in ParentView. The `update()` function is responsible for synchronizing the `ParentView`'s product list with the latest state of products managed by the `controller`. It ensures that changes in product data are reflected in the Views, maintaining consistency between the UI and the underlying data model.