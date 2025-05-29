package de.tum.mvc.database.Controller;

import de.tum.mvc.database.Model.DatabaseHelper;
import de.tum.mvc.database.Model.Product;
import de.tum.mvc.database.Model.ProductDAO;
import de.tum.mvc.database.View.AdminView;
import de.tum.mvc.database.View.CustomerView;

import java.util.List;

public class Controller {
    private final ProductDAO productDAO;

    private CustomerView customerView;

    private AdminView adminView;

    public Controller(DatabaseHelper databaseHelper) {
        this.productDAO = new ProductDAO(databaseHelper);
    }

    public void setAdminView(AdminView adminView) {
        this.adminView = adminView;
    }

    public void setCustomerView(CustomerView customerView) {
        this.customerView = customerView;
    }

    public void saveProduct(Product product) {
        Product savedProduct;
        if (product.getId() == -1) {
            int id = productDAO.saveProduct(product);
            savedProduct = new Product(id, product.getName(), product.getDescription(), product.getPrice(), product.getStoredQuantity());
        } else {
            // TODO: update product
        }
        // TODO: add to views if they are not null. Notify observers after
    }

    public List<Product> getProducts() {
        return productDAO.selectProducts();
    }

    // TODO: Implement this buyProduct() method
    public void buyProduct(Product product, int quantity) throws Exception {
    }

    public void deleteProduct(Product product) {
        boolean deleted = productDAO.deleteProduct(product);
        if (deleted) {
            product.notifyObservers();
            System.out.println("Product deleted successfully: " + product.getName());
        } else {
            System.out.println("Failed to delete product: " + product.getName());
        }
    }
}
