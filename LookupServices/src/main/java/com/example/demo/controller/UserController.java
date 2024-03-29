package com.example.demo.controller;

import com.example.demo.entity.AllBillsDetailsResponse;
import com.example.demo.entity.CheckInventoryResponse;
import com.example.demo.entity.GetUserDataResponse;
import com.example.demo.entity.GetUserListResponse;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.lookupservices.LookupServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/lookup")
public class UserController {

    @Autowired
    private LookupServicesImpl lookupServices;

    // Get -  http://desktop-81tnvp1:908/lookup/getusers
    @GetMapping("/getusers")
    public ResponseEntity<GetUserListResponse> getUsers() {
        GetUserListResponse userNames = new GetUserListResponse();
        try {
            // Your service method call
            userNames = lookupServices.getAllUsernames();

            // Check if the result is empty and throw EntityNotFoundException if needed
            if (userNames.getUserNames().isEmpty()) {
                throw new EntityNotFoundException("No users found");
            }

        } catch (EntityNotFoundException e) {
            // Log the exception or perform additional handling if needed
            e.printStackTrace();
            return ResponseEntity.status(404).body(userNames); // Custom response for not found
        } catch (Exception e) {
            // Log the exception or perform additional handling if needed
            e.printStackTrace();
            return ResponseEntity.status(500).body(userNames); // Generic error response
        }
        return ResponseEntity.ok(userNames);
    }

    // Get -  http://desktop-81tnvp1:9083/lookup/getusers-data
    @GetMapping("/getusers-data")
    public ResponseEntity<GetUserDataResponse> getUsersData() {
        GetUserDataResponse userData = new GetUserDataResponse();
        try {
            // Your service method call
            userData = lookupServices.getAllUserData();

            // Check if the result is empty and throw EntityNotFoundException if needed
            if (userData.getUserData().isEmpty()) {
                throw new EntityNotFoundException("No user data found");
            }

        } catch (EntityNotFoundException e) {
            // Log the exception or perform additional handling if needed
            e.printStackTrace();
            return ResponseEntity.status(404).body(userData); // Custom response for not found
        } catch (Exception e) {
            // Log the exception or perform additional handling if needed
            e.printStackTrace();
            return ResponseEntity.status(500).body(userData); // Generic error response
        }
        return ResponseEntity.ok(userData);
    }

    // Get -  http://desktop-81tnvp1:9083/lookup/all-bills-data
    @GetMapping("/all-bills-data")
    public ResponseEntity<AllBillsDetailsResponse> getAllBillsData() {
        AllBillsDetailsResponse response = new AllBillsDetailsResponse();
        try {
            // Your service method call
            response = lookupServices.getBillDetails();

            // Check if the result is empty and throw EntityNotFoundException if needed
            if (response.getBillDetailList().isEmpty()) {
                throw new EntityNotFoundException("No bill details found");
            }

        } catch (EntityNotFoundException e) {
            // Log the exception or perform additional handling if needed
            e.printStackTrace();
            return ResponseEntity.status(404).body(response); // Custom response for not found
        } catch (Exception e) {
            // Log the exception or perform additional handling if needed
            e.printStackTrace();
            return ResponseEntity.status(500).body(response); // Generic error response
        }
        return ResponseEntity.ok(response);
    }

    // Get -  http://desktop-81tnvp1:9083/lookup/inventoryDetails
    @GetMapping("/inventoryDetails")
    public ResponseEntity<CheckInventoryResponse> inventoryData() {
        CheckInventoryResponse response = new CheckInventoryResponse();
        try {
            // Your service method call
            response = lookupServices.getProductDetails();

            // Check if the result is empty and throw EntityNotFoundException if needed
            if (response.getInventoryDetails().isEmpty()) {
                throw new EntityNotFoundException("No inventory details found");
            }

        } catch (EntityNotFoundException e) {
            // Log the exception or perform additional handling if needed
            e.printStackTrace();
            return ResponseEntity.status(404).body(response); // Custom response for not found
        } catch (Exception e) {
            // Log the exception or perform additional handling if needed
            e.printStackTrace();
            return ResponseEntity.status(500).body(response); // Generic error response
        }
        return ResponseEntity.ok(response);
    }
}
