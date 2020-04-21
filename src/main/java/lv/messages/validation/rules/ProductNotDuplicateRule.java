package lv.messages.validation.rules;

import lv.messages.Product;
import lv.messages.ProductDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductNotDuplicateRule implements ProductValidationRule {

    private ProductDatabase database;

    @Autowired
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
        return "lv.messages.Product name must be unique!";
    }
}
