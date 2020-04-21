package lv.messages.validation.rules;

import lv.messages.Product;
import org.springframework.stereotype.Component;

@Component
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
        return "lv.messages.Product price cannot be 0 EUR!";
    }
}
