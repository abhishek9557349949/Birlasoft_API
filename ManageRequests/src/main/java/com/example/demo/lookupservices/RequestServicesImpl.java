package com.example.demo.lookupservices;

import com.example.demo.entity.BillInfo;
import com.example.demo.entity.BillInfoResponse;
import com.example.demo.lookupdao.RequestDao;
import com.example.exceptions.EmptyUserIdException;
import com.example.exceptions.IncorrectBillIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestServicesImpl implements RequestServices {

    @Autowired
    private RequestDao requestDao;

    @Override
    public boolean revokeUser(String userId) throws EmptyUserIdException {
        if (userId == null || userId.length() < 2) {
            throw new EmptyUserIdException("User ID cannot be empty or less than 2 characters");
        }
        if (requestDao.revokeAccessFromDB(userId)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean approveUser(String userId) throws EmptyUserIdException {
        if (userId == null || userId.length() < 2) {
            throw new EmptyUserIdException("User ID cannot be empty or less than 2 characters");
        }
        if (requestDao.approveAccessFromDB(userId)) {
            return true;
        }
        return false;
    }

    @Override
    public BillInfoResponse getBillData(BillInfoResponse response, Integer billId) throws IncorrectBillIdException {
        if (billId == null) {
            throw new IncorrectBillIdException("Bill ID cannot be null");
        }

        BillInfo billInfo = requestDao.getBillDataFromDB(billId);

        if (billInfo != null) {
            response.setBillInfo(billInfo);
        }
        return response;
    }
}
