package com.example.demo.controller;

import com.example.demo.constants.RequestConstants;
import com.example.demo.entity.BillInfo;
import com.example.demo.entity.BillInfoResponse;
import com.example.demo.entity.RevokeUserResponse;
import com.example.demo.lookupservices.RequestServices;
import com.example.exceptions.EmptyUserIdException;
import com.example.exceptions.IncorrectBillIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/request")
public class RequestController {

    @Autowired
    private RequestServices requestServices;
    
    @Autowired    
    RestTemplate rt;

    @PostMapping("/revoke-user")
    public RevokeUserResponse revokeUser(@RequestBody RevokeUserResponse request) {
        try {
            if (request.getUserId() == null || request.getUserId().isEmpty()) {
                throw new EmptyUserIdException(RequestConstants.EMPTY_USER_ID);
            }

            if (requestServices.revokeUser(request.getUserId())) {
                request.setResponse(RequestConstants.SUCCESS_MESSAGE);
            } else {
                request.setResponse(RequestConstants.FAILURE_MESSAGE);
            }
        } catch (EmptyUserIdException e) {
            // Log the exception or handle it as needed
            e.printStackTrace();
            request.setResponse(e.getMessage());
        } catch (Exception e) {
            // Log the exception or handle it as needed
            e.printStackTrace();
            request.setResponse(RequestConstants.UNEXPECTED_ERROR_MESSAGE);
        }
        return request;
    }

    @PostMapping("/approve-user")
    public RevokeUserResponse approveUser(@RequestBody RevokeUserResponse request) {
        try {
            if (request.getUserId() == null || request.getUserId().isEmpty()) {
                throw new EmptyUserIdException(RequestConstants.EMPTY_USER_ID);
            }

            if (requestServices.approveUser(request.getUserId())) {
                request.setResponse(RequestConstants.SUCCESS_MESSAGE);
            } else {
                request.setResponse(RequestConstants.FAILURE_MESSAGE);
            }
        } catch (EmptyUserIdException e) {
            // Log the exception or handle it as needed
            e.printStackTrace();
            request.setResponse(e.getMessage());
        } catch (Exception e) {
            // Log the exception or handle it as needed
            e.printStackTrace();
            request.setResponse(RequestConstants.UNEXPECTED_ERROR_MESSAGE);
        }
        return request;
    }

    @PostMapping("/get-specific-bill-info")
    public BillInfoResponse getSpecificBillInfo(@RequestBody BillInfo request) {
        BillInfoResponse response = new BillInfoResponse();
        try {
            if (request == null || request.getBillId() == null) {
                throw new IncorrectBillIdException(RequestConstants.INCORRECT_BILL_ID);
            }

            response = requestServices.getBillData(response, request.getBillId());

            if (response.getBillInfo() != null) {
                response.setResponse(RequestConstants.SUCCESS_MESSAGE);
            } else {
                response.setResponse(RequestConstants.FAILURE_MESSAGE);
            }
        } catch (IncorrectBillIdException e) {
            // Log the exception or handle it as needed
            e.printStackTrace();
            response.setResponse(e.getMessage());
        } catch (Exception e) {
            // Log the exception or handle it as needed
            e.printStackTrace();
            response.setResponse(RequestConstants.UNEXPECTED_ERROR_MESSAGE);
        }
        return response;
    }
}
