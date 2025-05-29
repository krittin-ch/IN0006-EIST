package de.tum.mvc.database.Model;

import java.util.List;

public class ProductDAO {

    private final DatabaseHelper databaseHelper;

    public ProductDAO(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    // TODO: Implement saveProduct
    public int saveProduct(Product product) {
        return -1;
    }

    // TODO: Implement updateProduct
    public Product updateProduct(Product product) {
        return null;
    }

    // TODO: Implement selectProducts
    public List<Product> selectProducts() {
        return List.of();
    }

    // TODO: Implement deleteProduct
    public boolean deleteProduct(Product product) {
        return false;
    }

    public Product selectProductById(int id) {
        Product product = databaseHelper.selectProductById(id);

        if (product == null) {
            System.out.println("Couldn't find product with id: " + id);
        }

        return product;
    }
}
