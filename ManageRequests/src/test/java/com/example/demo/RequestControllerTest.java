package com.example.demo;

import com.example.demo.constants.RequestConstants;
import com.example.demo.controller.RequestController;
import com.example.demo.entity.BillInfo;
import com.example.demo.entity.BillInfoResponse;
import com.example.demo.entity.RevokeUserResponse;
import com.example.demo.lookupservices.RequestServices;
import com.example.exceptions.EmptyUserIdException;
import com.example.exceptions.IncorrectBillIdException;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class RequestControllerTest {

    @Mock
    private RequestServices requestServices;

    @InjectMocks
    private RequestController requestController;
    
    @Captor
    private ArgumentCaptor<Integer> billIdCaptor;

    @Test
    public void testRevokeUserSuccess() {
        RevokeUserResponse request = new RevokeUserResponse();
        request.setUserId("user123");

        Mockito.when(requestServices.revokeUser(Mockito.anyString())).thenReturn(true);

        RevokeUserResponse result = requestController.revokeUser(request);

        assertEquals(RequestConstants.SUCCESS_MESSAGE, result.getResponse());
    }


    @Test
    public void testRevokeUserFailure() {
        RevokeUserResponse request = new RevokeUserResponse();
        request.setUserId("user123");

        Mockito.when(requestServices.revokeUser(Mockito.anyString())).thenReturn(false);

        RevokeUserResponse result = requestController.revokeUser(request);

        assertEquals(RequestConstants.FAILURE_MESSAGE, result.getResponse());
    }

    @Test
    public void testApproveUserSuccess() {
        RevokeUserResponse request = new RevokeUserResponse();
        request.setUserId("user123");

        Mockito.when(requestServices.approveUser(Mockito.anyString())).thenReturn(true);

        RevokeUserResponse result = requestController.approveUser(request);

        assertEquals(RequestConstants.SUCCESS_MESSAGE, result.getResponse());
    }

    @Test
    public void testApproveUserFailure() {
        RevokeUserResponse request = new RevokeUserResponse();
        request.setUserId("user123");

        Mockito.when(requestServices.approveUser(Mockito.anyString())).thenReturn(false);

        RevokeUserResponse result = requestController.approveUser(request);

        assertEquals(RequestConstants.FAILURE_MESSAGE, result.getResponse());
    }


    
    @Test
    public void testGetSpecificBillInfoFailure() {
        BillInfo request = new BillInfo();
        request.setBillId(1);

        BillInfoResponse response = new BillInfoResponse();

        Mockito.when(requestServices.getBillData(Mockito.any(), billIdCaptor.capture())).thenReturn(new BillInfoResponse());

        BillInfoResponse result = requestController.getSpecificBillInfo(request);

        assertEquals(RequestConstants.FAILURE_MESSAGE, result.getResponse());
        assertEquals(1, billIdCaptor.getValue()); // Make sure the captured argument is as expected
    }

    // Add more tests as needed...

}
