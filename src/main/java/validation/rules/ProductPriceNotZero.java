package main.java.validation.rules;

import main.java.Product;

public class ProductPriceNotZero implements ProductValidationRule {
    @Override
    public boolean isValid(Product product) {
        if (product.getPrice() == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String getErrorMessage() {
        return "main.java.Product price cannot be 0 EUR!";
    }
}
