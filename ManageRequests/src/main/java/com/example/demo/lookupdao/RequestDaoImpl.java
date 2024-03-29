package com.example.demo.lookupdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.BillInfo;
import com.example.demo.entity.UserData;
import com.example.demo.repository.DBConnector;
import com.example.demo.repository.SQLString;

import org.springframework.stereotype.Service;

@Service
public class RequestDaoImpl implements RequestDao{

	@Override
	public boolean revokeAccessFromDB(String userId) {
		try {
			String revokeQuery = SQLString.REVOKEUSER_STRING;
	        Connection connection = DBConnector.getNewConnection();
	        assert connection != null;
	        PreparedStatement statement = connection.prepareStatement(revokeQuery);
	        statement.setString(1, userId);
	        int isRequestCompleted = statement.executeUpdate();
	
	        if(isRequestCompleted != 0) {
	        	return true;
	        }
	        statement.close();
	        DBConnector.closeConnection(connection);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean approveAccessFromDB(String userId) {
		try {
			String revokeQuery = SQLString.REVOKEUSER_STRING;
	        Connection connection = DBConnector.getNewConnection();
	        assert connection != null;
	        PreparedStatement statement = connection.prepareStatement(revokeQuery);
	        statement.setString(1, userId);
	        int isRequestCompleted = statement.executeUpdate();
	
	        if(isRequestCompleted != 0) {
	        	return true;
	        }
	        statement.close();
	        DBConnector.closeConnection(connection);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public BillInfo getBillDataFromDB(Integer billId) {
		try {
			String billInfoQuery = SQLString.GET_ANY_BILL_INFO_STRING;
	        Connection connection = DBConnector.getNewConnection();
	        assert connection != null;
	        PreparedStatement statement = connection.prepareStatement(billInfoQuery);
	        statement.setLong(1, billId);
	        ResultSet resultSet = statement.executeQuery();
	
	        BillInfo billInfo = new BillInfo();
	        while(resultSet.next()) {
	        	billInfo.setBillId(resultSet.getInt("BILL_ID"));
	        	billInfo.setBillDate(resultSet.getDate("BILL_DATE"));
	        	billInfo.setTotalAmount(resultSet.getDouble("TOTAL_AMOUNT"));
	        	billInfo.setDiscount(resultSet.getDouble("DISCOUNT"));
	        	billInfo.setCustomerName(resultSet.getString("CUSTOMER_NAME"));
	        	billInfo.setEmail(resultSet.getString("EMAIL"));
	        	billInfo.setPhoneNumber(resultSet.getString("PHONE_NUMBER"));
	        	billInfo.setAddress(resultSet.getString("ADDRESS"));
	        	billInfo.setProductName(resultSet.getString("PRODUCT_NAME"));
	        	billInfo.setProductUnitPrice(resultSet.getDouble("PRODUCT_UNIT_PRICE"));
	        	billInfo.setQuantity(resultSet.getInt("QUANTITY"));
	        }
	        
	        resultSet.close();
	        statement.close();
	        DBConnector.closeConnection(connection);
	        return billInfo;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
