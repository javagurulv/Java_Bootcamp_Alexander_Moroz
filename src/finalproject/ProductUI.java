package finalproject;

import finalproject.validation.ProductValidator;
import finalproject.validation.rules.ProductNameNotEmptyRule;
import finalproject.validation.rules.ProductNotDuplicateRule;
import finalproject.validation.rules.ProductPriceNotZero;
import finalproject.validation.rules.ProductValidationRule;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductUI {

    public static void main(String[] args) {
        ProductDatabase database = new ProductDatabase();

        List<ProductValidationRule> rules = new ArrayList<>();
        rules.add(new ProductNameNotEmptyRule());
        rules.add(new ProductNotDuplicateRule(database));
        rules.add(new ProductPriceNotZero());

        ProductValidator productValidator = new ProductValidator(rules);

        ProductService productService = new ProductService(database, productValidator);

        while (true) {
            // print menu
            System.out.println("Program menu:");
            System.out.println("1. Add new product");
            System.out.println("2. Show product list");
            System.out.println("3. Exit");

            // get user choice
            Scanner sc = new Scanner(System.in);
            System.out.println("Select option: ");
            int userChoice = Integer.parseInt(sc.nextLine());

            // execute user choice
            if (userChoice == 1) {
                // add new product
                String productName;
                double productPrice;
                System.out.println("Enter product name:");
                productName = sc.nextLine();
                while (true){
                    try {
                        System.out.println("Enter product price:");
                        productPrice = Double.parseDouble(sc.nextLine());
                        break;
                    } catch (NumberFormatException error){
                        System.out.println("Please enter a number! ");

                    }
                }

                Product product = new Product(productName, productPrice);

                // invoke BL
                AddProductResponse response = productService.addProduct(product);
                if (response.isSuccess()) {
                    System.out.println("Operation successful!");
                } else {
                    System.out.println("Operation failed!");
                    System.out.println("Error message: " + response.getErrorMessage());
                }
            }

            if (userChoice == 2) {
                // Show product list
                List<Product> products = productService.getProductList();
                products.forEach(product -> System.out.println(product.toString()));
            }

            if (userChoice == 3) {
                // exit from program
                System.out.println("Goodbye!");
                break;
            }

            System.out.println();

            // exit condition
        }

    }

}
