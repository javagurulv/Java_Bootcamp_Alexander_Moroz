package lv.messages.validation.rules;

import lv.messages.Product;
import org.springframework.stereotype.Component;

@Component
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
