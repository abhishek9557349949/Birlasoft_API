package com.example.demo;

import com.example.demo.controller.UserController;
import com.example.demo.entity.AllBillsDetailsResponse;
import com.example.demo.entity.BillDetails;
import com.example.demo.entity.CheckInventoryResponse;
import com.example.demo.entity.GetUserDataResponse;
import com.example.demo.entity.GetUserListResponse;
import com.example.demo.entity.InventoryDetails;
import com.example.demo.entity.UserData;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.lookupservices.LookupServicesImpl;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LookupServicesImpl lookupServices;

    @Test
    void testGetUsers() throws Exception {
        GetUserListResponse userNames = new GetUserListResponse();
        userNames.setUserNames(Arrays.asList("user1", "user2"));

        Mockito.when(lookupServices.getAllUsernames()).thenReturn(userNames);

        mockMvc.perform(MockMvcRequestBuilders.get("/lookup/getusers")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.userNames").exists());
    }

    @Test
    void testGetUsersData() throws Exception {
        GetUserDataResponse userData = new GetUserDataResponse();

        // Assuming UserData has a constructor that accepts a String argument
        UserData userData1 = new UserData();
        UserData userData2 = new UserData();

        userData.setUserData(Arrays.asList(userData1, userData2));

        Mockito.when(lookupServices.getAllUserData()).thenReturn(userData);

        mockMvc.perform(MockMvcRequestBuilders.get("/lookup/getusers-data")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.userData").exists());
    }

    @Test
    void testGetAllBillsData() throws Exception {
        AllBillsDetailsResponse response = new AllBillsDetailsResponse();

        // Assuming BillDetails has a constructor that accepts a String argument
        BillDetails billDetails1 = new BillDetails();
        BillDetails billDetails2 = new BillDetails();

        response.setBillDetailList(Arrays.asList(billDetails1, billDetails2));

        Mockito.when(lookupServices.getBillDetails()).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.get("/lookup/all-bills-data")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.billDetailList").exists());
    }

    @Test
    void testInventoryData() throws Exception {
        CheckInventoryResponse response = new CheckInventoryResponse();

        // Assuming InventoryDetails has a constructor that accepts a String argument
        InventoryDetails inventoryDetails1 = new InventoryDetails();
        InventoryDetails inventoryDetails2 = new InventoryDetails();

        response.setInventoryDetails(Arrays.asList(inventoryDetails1, inventoryDetails2));

        Mockito.when(lookupServices.getProductDetails()).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.get("/lookup/inventoryDetails")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.inventoryDetails").exists());
    }
}
