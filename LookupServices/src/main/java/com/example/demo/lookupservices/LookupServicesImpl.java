package com.example.demo.lookupservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.constants.LookupConstants;
import com.example.demo.entity.AllBillsDetailsResponse;
import com.example.demo.entity.CheckInventoryResponse;
import com.example.demo.entity.GetUserDataResponse;
import com.example.demo.entity.GetUserListResponse;
import com.example.demo.lookupdao.LookupDaoImpl;


@Service
public class LookupServicesImpl{

	@Autowired
    private LookupDaoImpl lookupDao;

//    @Override
    public GetUserListResponse getAllUsernames() {
    	GetUserListResponse userResponse = new GetUserListResponse();
        try {
            userResponse.setUserNames(lookupDao.getAllUserNameFromDB());
            userResponse.setResponse(LookupConstants.SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userResponse;
    }

	public GetUserDataResponse getAllUserData() {
		GetUserDataResponse userResponse = new GetUserDataResponse();
        try {
        	userResponse.setUserData(lookupDao.getAllUserDataFromDB());
            userResponse.setResponse(LookupConstants.SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userResponse;
	}

	public AllBillsDetailsResponse getBillDetails() {
		AllBillsDetailsResponse billResponse = new AllBillsDetailsResponse();
        try {
        	billResponse.setBillDetailList(lookupDao.getAllBillsDataFromDB());
        	billResponse.setResponse(LookupConstants.SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return billResponse;
	}

	public CheckInventoryResponse getProductDetails() {
		CheckInventoryResponse productResponse = new CheckInventoryResponse();
        try {
        	productResponse.setInventoryDetails(lookupDao.getAllproductDataFromDB());
        	productResponse.setRespose(LookupConstants.SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productResponse;
	}
}
