package main.java.validation;

import main.java.Product;
import main.java.validation.rules.ProductValidationRule;

import java.util.ArrayList;
import java.util.List;

public class ProductValidator {

    private List<ProductValidationRule> rules;

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
