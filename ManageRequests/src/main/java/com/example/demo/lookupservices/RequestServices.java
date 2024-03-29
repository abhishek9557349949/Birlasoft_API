package com.example.demo.lookupservices;

import com.example.demo.entity.BillInfoResponse;

public interface RequestServices {
    boolean revokeUser(String userId);

    boolean approveUser(String userId);

    BillInfoResponse getBillData(BillInfoResponse response, Integer billId);
}
