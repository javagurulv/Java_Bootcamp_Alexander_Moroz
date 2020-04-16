package main.java;

import main.java.validation.ProductValidator;

import java.util.List;

public class ProductService {

    private ProductDatabase database;
    private ProductValidator productValidator;

    public ProductService(ProductDatabase database,
                          ProductValidator productValidator) {
        this.database = database;
        this.productValidator = productValidator;
    }

    public AddProductResponse addProduct(Product product) {
        List<String> validationErrors = productValidator.validate(product);
        if (validationErrors.isEmpty()) {
            database.addProduct(product);
            return new AddProductResponse(true, null);
        } else {
            return new AddProductResponse(false, validationErrors);
        }
    }


    public List<Product> getProductList() {
        return database.getProducts();
    }

}
