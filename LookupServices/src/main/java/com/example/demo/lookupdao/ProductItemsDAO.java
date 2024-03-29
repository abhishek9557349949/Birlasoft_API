package com.example.demo.lookupdao;

import com.example.demo.entity.ProductItems;
import com.example.demo.repository.DBConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductItemsDAO {

    private static final String SELECT_ALL_PRODUCTS = "SELECT * FROM bms_products";
    private static final String INSERT_PRODUCT = "INSERT INTO bms_products VALUES (?, ?, ?, ?, ?, ?)";
    // Add other SQL queries as needed

    public List<ProductItems> getAllProducts() {
        List<ProductItems> products = new ArrayList<>();
        try (Connection connection = DBConnector.getNewConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_PRODUCTS)) {

            while (resultSet.next()) {
                ProductItems product = new ProductItems(
                        resultSet.getString("productName"),
                        resultSet.getString("description"),
                        resultSet.getString("category"),
                        resultSet.getDouble("unitPrice"),
                        resultSet.getInt("stockQuantity"),
                        resultSet.getDate("expirationDate"),
                        resultSet.getDouble("discount")
                );
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public void addProduct(ProductItems product) {
        try (Connection connection = DBConnector.getNewConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT)) {

            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getCategory());
            preparedStatement.setDouble(3, product.getUnitPrice());
            preparedStatement.setInt(4, product.getStockQuantity());
            preparedStatement.setDate(5, product.getExpirationDate());
            preparedStatement.setDouble(6, product.getDiscount());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Add other methods for updating, deleting, etc.
}
