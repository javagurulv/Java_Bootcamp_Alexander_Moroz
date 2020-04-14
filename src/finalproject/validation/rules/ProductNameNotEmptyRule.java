package finalproject.validation.rules;

import finalproject.Product;

public class ProductNameNotEmptyRule implements ProductValidationRule {

    @Override
    public boolean isValid(Product product) {
        if (product.getName() == null || product.getName().equals("")) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String getErrorMessage() {
        return "Empty product name!";
    }

}
