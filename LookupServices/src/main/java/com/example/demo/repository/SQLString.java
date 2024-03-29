package com.example.demo.repository;

public class SQLString {

	public static final String GET_USERNAME_STRING = "SELECT USER_NAME FROM hix_bms_data.bms_login_data";

	public static final String GET_USERDATA_STRING = "SELECT USER_NAME, MAIL_ID, CLIENT_NAME, ACCOUNT_STATUS, BUSINESS_NAME, ROLE FROM hix_bms_data.bms_login_data where ROLE != 'BMS_OWNER' AND ACCOUNT_STATUS = 'Active';";

	public static final String getBillsList = "SELECT b.BILL_ID, CONCAT(c.FIRST_NAME, ' ', c.LAST_NAME) AS CUSTOMER_NAME, c.PHONE_NUMBER, b.BILL_DATE, b.TOTAL_AMOUNT, b.DISCOUNT, CONCAT(c.ADDRESS, ' ', c.CITY) AS"
			+ " CUSTOMER_ADDRESS FROM bms_bills b JOIN bms_customers c ON b.CUSTOMER_ID = c.CUSTOMER_ID;";

	public static final String getProductDetails = "SELECT PRODUCT_NAME, UNIT_PRICE, STOCK_QUANTITY, EXPIRATION_DATE, DISCOUNT, CASE WHEN STOCK_QUANTITY < 55 THEN 'Buy Now'"
            + " WHEN STOCK_QUANTITY <= 75 THEN 'Order Soon' ELSE 'Sufficient Amount' END AS order_status FROM hix_bms_data.bms_products;";
	
}
