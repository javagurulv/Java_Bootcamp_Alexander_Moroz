package lv.messages.validation.rules;

import lv.messages.Product;

public interface ProductValidationRule {

    boolean isValid(Product product);

    String getErrorMessage();

}
