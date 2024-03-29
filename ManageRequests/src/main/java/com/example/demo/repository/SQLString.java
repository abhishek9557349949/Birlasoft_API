package com.example.demo.repository;

public class SQLString {

	public static final String REVOKEUSER_STRING = "UPDATE hix_bms_data.bms_login_data SET ACCOUNT_STATUS = 'Disabled' WHERE USER_NAME = ?;";

	public static final String APPROVEUSER_STRING = "UPDATE hix_bms_data.bms_login_data SET APPROVED_BY_OWNER = 'Y' WHERE USER_NAME = ?;";
	
	public static final String GET_ANY_BILL_INFO_STRING = "SELECT b.BILL_ID, b.BILL_DATE, b.TOTAL_AMOUNT, b.DISCOUNT, CONCAT(c.FIRST_NAME, ' ', c.LAST_NAME) AS CUSTOMER_NAME, c.EMAIL, c.PHONE_NUMBER, c.ADDRESS, p.PRODUCT_NAME,"
			+ " p.UNIT_PRICE AS PRODUCT_UNIT_PRICE, bi.QUANTITY, CASE WHEN b.DISCOUNT IS NOT NULL THEN ((bi.UNIT_PRICE * bi.QUANTITY) - (b.DISCOUNT / 100 * (bi.UNIT_PRICE * bi.QUANTITY))) + ((bi.UNIT_PRICE * bi.QUANTITY) * 0.05) "
			+ "ELSE (bi.UNIT_PRICE * bi.QUANTITY) + (bi.UNIT_PRICE * bi.QUANTITY * 0.05) END AS TOTAL_PRICE FROM bms_bills b JOIN bms_customers c ON b.CUSTOMER_ID = c.CUSTOMER_ID JOIN bms_bill_items bi ON b.BILL_ID = bi.BILL_ID JOIN "
			+ "bms_products p ON bi.PRODUCT_ID = p.PRODUCT_ID WHERE b.BILL_ID = ?;";
}
