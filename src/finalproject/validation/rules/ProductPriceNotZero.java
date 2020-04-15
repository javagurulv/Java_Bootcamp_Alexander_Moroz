package finalproject.validation.rules;

import finalproject.Product;

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
        return "Product price cannot be 0 EUR!";
    }
}
