package com.example.demo.lookupdao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
 
import com.example.demo.entity.BillDetails;
import com.example.demo.entity.InventoryDetails;
import com.example.demo.entity.UserData;
import com.example.demo.repository.DBConnector;
import com.example.demo.repository.SQLString;
 
import org.springframework.stereotype.Service;
 
@Service
public class LookupDaoImpl{
 
// @Override
public List<String> getAllUserNameFromDB(){
List<String> userNameList = new ArrayList<String>();
try {
String userNameQuery = SQLString.GET_USERNAME_STRING;
        Connection connection = DBConnector.getNewConnection();
        assert connection != null;
        PreparedStatement statement = connection.prepareStatement(userNameQuery);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()) {
         userNameList.add(resultSet.getString("USER_NAME"));
        }
        resultSet.close();
        statement.close();
        DBConnector.closeConnection(connection);
}catch(Exception e) {
e.printStackTrace();
}
return userNameList;
}
 
public List<UserData> getAllUserDataFromDB() {
List<UserData> userDataList = new ArrayList<UserData>();
try {
String userDataQuery = SQLString.GET_USERDATA_STRING;
        Connection connection = DBConnector.getNewConnection();
        assert connection != null;
        PreparedStatement statement = connection.prepareStatement(userDataQuery);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()) {
         UserData userData = new UserData();
         userData.setUserName(resultSet.getString("USER_NAME"));
         userData.setMailId(resultSet.getString("MAIL_ID"));
         userData.setEmployeeName(resultSet.getString("CLIENT_NAME"));
         userData.setAccountStatus(resultSet.getString("ACCOUNT_STATUS"));
         userData.setBuisnessName(resultSet.getString("BUSINESS_NAME"));
         userData.setRole(resultSet.getString("ROLE"));
         userDataList.add(userData);
        }
        resultSet.close();
        statement.close();
        DBConnector.closeConnection(connection);
}catch(Exception e) {
e.printStackTrace();
}
return userDataList;
}
 
public List<BillDetails> getAllBillsDataFromDB() {
List<BillDetails> billDataList = new ArrayList<BillDetails>();
try {
String billsDataQuery = SQLString.getBillsList;
        Connection connection = DBConnector.getNewConnection();
        assert connection != null;
        PreparedStatement statement = connection.prepareStatement(billsDataQuery);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()) {
         BillDetails billData = new BillDetails();
         billData.setBillId(resultSet.getInt("BILL_ID"));
         billData.setCustomerName(resultSet.getString("CUSTOMER_NAME"));
         billData.setPhoneNumber(resultSet.getString("PHONE_NUMBER"));
         billData.setBillDate(resultSet.getDate("BILL_DATE"));
         billData.setTotalAmount(resultSet.getDouble("TOTAL_AMOUNT"));
         billData.setDiscount(resultSet.getDouble("DISCOUNT"));
         billData.setCustomerAddress(resultSet.getString("CUSTOMER_ADDRESS"));
         billDataList.add(billData);
        }
        resultSet.close();
        statement.close();
        DBConnector.closeConnection(connection);
}catch(Exception e) {
e.printStackTrace();
}
return billDataList;
}
 
public List<InventoryDetails> getAllproductDataFromDB() {
List<InventoryDetails> inventoryDataList = new ArrayList<InventoryDetails>();
try {
String inventoryDataQuery = SQLString.getProductDetails;
        Connection connection = DBConnector.getNewConnection();
        assert connection != null;
        PreparedStatement statement = connection.prepareStatement(inventoryDataQuery);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()) {
         InventoryDetails inventoryDetails = new InventoryDetails();
         inventoryDetails.setProductName(resultSet.getString("PRODUCT_NAME"));
         inventoryDetails.setUnitPrice(resultSet.getDouble("UNIT_PRICE"));
         inventoryDetails.setStockQuantity(resultSet.getInt("STOCK_QUANTITY"));
         inventoryDetails.setExpirationDate(resultSet.getDate("EXPIRATION_DATE"));
         inventoryDetails.setDiscount(resultSet.getDouble("DISCOUNT"));
         inventoryDetails.setOrderStatus(resultSet.getString("order_status"));
         inventoryDataList.add(inventoryDetails);
        }
        resultSet.close();
        statement.close();
        DBConnector.closeConnection(connection);
}catch(Exception e) {
e.printStackTrace();
}
return inventoryDataList;
}
 
}