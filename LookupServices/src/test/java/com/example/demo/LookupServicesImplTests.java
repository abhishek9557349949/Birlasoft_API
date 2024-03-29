package com.example.demo;

import com.example.demo.entity.AllBillsDetailsResponse;
import com.example.demo.entity.BillDetails;
import com.example.demo.lookupdao.LookupDaoImpl;
import com.example.demo.lookupservices.LookupServicesImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class LookupServicesImplTest {

    @Mock
    private LookupDaoImpl lookupDao;

    @InjectMocks
    private LookupServicesImpl lookupServices;

    @Test
    void testGetBillDetails() {
        // Mock data from the database
        BillDetails billDetails1 = new BillDetails();
        billDetails1.setBillId(1);
        billDetails1.setCustomerName("Customer1");
        billDetails1.setPhoneNumber("1234567890");
        // Set other properties...

        BillDetails billDetails2 = new BillDetails();
        billDetails2.setBillId(2);
        billDetails2.setCustomerName("Customer2");
        billDetails2.setPhoneNumber("9876543210");
        // Set other properties...

        List<BillDetails> mockBillDetailsList = Arrays.asList(billDetails1, billDetails2);

        // Mock the behavior of lookupDao.getAllBillsDataFromDB()
        Mockito.when(lookupDao.getAllBillsDataFromDB()).thenReturn(mockBillDetailsList);

        // Test the service method
        AllBillsDetailsResponse response = lookupServices.getBillDetails();

        // Assertions
        Assertions.assertNotNull(response);
        List<BillDetails> actualBillDetailsList = response.getBillDetailList();
        Assertions.assertEquals(mockBillDetailsList.size(), actualBillDetailsList.size());
        Assertions.assertEquals(mockBillDetailsList.get(0).getBillId(), actualBillDetailsList.get(0).getBillId());
        Assertions.assertEquals(mockBillDetailsList.get(1).getCustomerName(), actualBillDetailsList.get(1).getCustomerName());
        // Add more assertions based on your entity structure...
    }

    // Add similar tests for other service methods...
}
