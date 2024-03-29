package com.example.demo.lookupdao;

import com.example.demo.entity.BillInfo;

public interface RequestDao {

	boolean revokeAccessFromDB(String userId);

	boolean approveAccessFromDB(String userId);

	BillInfo getBillDataFromDB(Integer billID);

}
