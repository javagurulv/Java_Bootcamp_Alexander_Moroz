package finalproject.validation.rules;

import finalproject.Product;

public interface ProductValidationRule {

    boolean isValid(Product product);

    String getErrorMessage();

}
