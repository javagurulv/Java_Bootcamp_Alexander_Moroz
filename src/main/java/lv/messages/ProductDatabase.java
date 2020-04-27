package lv.messages;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDatabase {
    @Value("${spring.datasource.url}")
    private String jdbcUrl;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClass;

    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.password}")
    private String password;


    private final List<Product> products = new ArrayList<>();

    protected Connection getConnection() {
        try {
            return DriverManager.getConnection(jdbcUrl, userName, password);
        } catch (SQLException e) {
            System.out.println("Exception while getting connection to database");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    protected void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Exception while closing connection to database");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    public void addProduct(Product product) {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "INSERT into ProductList(ID, Name, Price) values(default, ?, ?)";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                product.setId(rs.getInt(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute addProduct");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<Product> getProducts() {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "SELECT * FROM ProductList";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("ID"));
                product.setName(resultSet.getString("Name"));
                product.setPrice(resultSet.getDouble("Price"));
                products.add(product);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting products - getProducts");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
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

