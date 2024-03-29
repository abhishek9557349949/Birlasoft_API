package com.example.demo.repository;

import com.example.demo.entity.ProductItems;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public class ProductRepository {

    private Connection connection;

    public ProductRepository() {
        try {
            this.connection = DBConnector.getNewConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }

    public void addItem(ProductItems item) {
        String query = "INSERT INTO bms_products (PRODUCT_NAME, DESCRIPTION, CATEGORY, UNIT_PRICE, STOCK_QUANTITY, EXPIRATION_DATE, DISCOUNT) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, item.getProductName());
            preparedStatement.setString(2, item.getDescription());
            preparedStatement.setString(3, item.getCategory());
            preparedStatement.setDouble(4, item.getUnitPrice());
            preparedStatement.setInt(5, item.getStockQuantity());
            preparedStatement.setDate(6, item.getExpirationDate());
            preparedStatement.setDouble(7, item.getDiscount());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        }
        catch (SQLException e) {
          e.printStackTrace();
//           Handle exceptions appropriately
      }
    }
//            if (generatedKeys.next()) {
//                item.setProductId(generatedKeys.getLong(1));
//            }
//        } 
            
    

    // Add methods for deleteItem and updateItem

    public List<ProductItems> getAllProducts() {
        List<ProductItems> products = new ArrayList<>();
        String query = "SELECT * FROM bms_products";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                ProductItems product = new ProductItems();
               
                product.setProductName(resultSet.getString("PRODUCT_NAME"));
                product.setDescription(resultSet.getString("DESCRIPTION"));
                product.setCategory(resultSet.getString("CATEGORY"));
                product.setUnitPrice(resultSet.getDouble("UNIT_PRICE"));
                product.setStockQuantity(resultSet.getInt("STOCK_QUANTITY"));
                product.setExpirationDate(resultSet.getDate("EXPIRATION_DATE"));
                product.setDiscount(resultSet.getDouble("DISCOUNT"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
        return products;
    }

    public void deleteItem(String productName) {
        String query = "DELETE FROM bms_products WHERE PRODUCT_NAME = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, productName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }

    public void updateItem(ProductItems updatedItem) {
        String query = "UPDATE bms_products SET DESCRIPTION = ?, CATEGORY = ?, UNIT_PRICE = ?, " +
                "STOCK_QUANTITY = ?, EXPIRATION_DATE = ?, DISCOUNT = ? WHERE PRODUCT_NAME = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, updatedItem.getDescription());
            preparedStatement.setString(2, updatedItem.getCategory());
            preparedStatement.setDouble(3, updatedItem.getUnitPrice());
            preparedStatement.setInt(4, updatedItem.getStockQuantity());
            preparedStatement.setDate(5, updatedItem.getExpirationDate());
            preparedStatement.setDouble(6, updatedItem.getDiscount());
            preparedStatement.setString(7, updatedItem.getProductName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }
    
    public void closeConnection() {
        try {
            DBConnector.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }
    

	
}
