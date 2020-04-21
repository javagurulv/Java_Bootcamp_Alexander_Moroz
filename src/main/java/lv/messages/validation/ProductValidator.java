package lv.messages.validation;

import lv.messages.Product;
import lv.messages.validation.rules.ProductValidationRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ProductValidator {

    private List<ProductValidationRule> rules;

    @Autowired
    public ProductValidator(List<ProductValidationRule> rules) {
        this.rules = rules;
    }

    public List<String> validate(Product product) {
        List<String> errors = new ArrayList<>();

        for (ProductValidationRule rule : rules) {
            boolean ruleIsValid = rule.isValid(product);
            if (ruleIsValid == false) {
                errors.add(rule.getErrorMessage());
            }
        }

        return errors;
    }

}
