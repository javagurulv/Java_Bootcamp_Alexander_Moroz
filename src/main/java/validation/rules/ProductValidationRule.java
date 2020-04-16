package main.java.validation.rules;

import main.java.Product;

public interface ProductValidationRule {

    boolean isValid(Product product);

    String getErrorMessage();

}
