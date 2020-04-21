package lv.messages;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ProductDatabase {
    private int currentID = 1;
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        product.setId(currentID);
        products.add(product);
        this.currentID++;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductByName(String productName) {
        Product product = null;
        for (Product p : products) {
            if (p.getName().equals(productName)) {
                product = p;
            }
        }
        return product;
    }

}
