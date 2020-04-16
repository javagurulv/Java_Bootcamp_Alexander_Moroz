package main.java.validation.rules;

import main.java.Product;
import main.java.ProductDatabase;

public class ProductNotDuplicateRule implements ProductValidationRule {

    private ProductDatabase database;

    public ProductNotDuplicateRule(ProductDatabase database) {
        this.database = database;
    }

    @Override
    public boolean isValid(Product product) {
        Product productFromDb = database.getProductByName(product.getName());
        if (productFromDb != null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String getErrorMessage() {
        return "main.java.Product name must be unique!";
    }
}
