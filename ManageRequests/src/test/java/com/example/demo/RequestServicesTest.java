package com.example.demo;

import com.example.demo.constants.RequestConstants;
import com.example.demo.entity.BillInfo;
import com.example.demo.entity.BillInfoResponse;
import com.example.demo.lookupdao.RequestDao;
import com.example.demo.lookupservices.RequestServices;
import com.example.demo.lookupservices.RequestServicesImpl;
import com.example.exceptions.EmptyUserIdException;
import com.example.exceptions.IncorrectBillIdException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest
public class RequestServicesTest {
	  @Mock
	    private RequestDao requestDao;

	    @InjectMocks
	    private RequestServicesImpl requestServices;

	    @Test
	    public void testRevokeUserSuccess() throws EmptyUserIdException {
	        String userId = "user123";

	        Mockito.when(requestDao.revokeAccessFromDB(anyString())).thenReturn(true);

	        boolean result = requestServices.revokeUser(userId);

	        assertTrue(result);
	    }

	    @Test
	    public void testRevokeUserFailure() throws EmptyUserIdException {
	        String userId = "user123";

	        Mockito.when(requestDao.revokeAccessFromDB(anyString())).thenReturn(false);

	        boolean result = requestServices.revokeUser(userId);

	        assertFalse(result);
	    }

	    @Test
	    public void testRevokeUserEmptyUserId() {
	        String userId = null;

	        assertThrows(EmptyUserIdException.class, () -> requestServices.revokeUser(userId));
	    }

	    @Test
	    public void testApproveUserSuccess() throws EmptyUserIdException {
	        String userId = "user123";

	        Mockito.when(requestDao.approveAccessFromDB(anyString())).thenReturn(true);

	        boolean result = requestServices.approveUser(userId);

	        assertTrue(result);
	    }

	    @Test
	    public void testApproveUserFailure() throws EmptyUserIdException {
	        String userId = "user123";

	        Mockito.when(requestDao.approveAccessFromDB(anyString())).thenReturn(false);

	        boolean result = requestServices.approveUser(userId);

	        assertFalse(result);
	    }

	    @Test
	    public void testApproveUserEmptyUserId() {
	        String userId = null;

	        assertThrows(EmptyUserIdException.class, () -> requestServices.approveUser(userId));
	    }

	   

	   

	    @Test
	    public void testGetBillDataIncorrectBillId() {
	        Integer billId = null;

	        assertThrows(IncorrectBillIdException.class, () -> requestServices.getBillData(new BillInfoResponse(), billId));
	    }
}
