package com.example.demo;

import com.example.demo.entity.LoginData;
import com.example.demo.exceptions.ControllerException;
import com.example.demo.exceptions.ServiceException;
import com.example.demo.lookupservices.LookupServicesImpl;
import com.example.demo.lookupdao.LookupDaoImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LookupServicesImplTest {

    @InjectMocks
    private LookupServicesImpl lookupServices;

    @Mock
    private LookupDaoImpl lookupDao;

    @Test
    public void testGetLoginDetails_Success() throws Exception {
        LoginData loginData = new LoginData("John", "john@example.com", 0, "Active", "Business", "User", "Yes", "john123", "password", null);
        when(lookupDao.getUserDetails(any())).thenReturn(loginData);

        LoginData result = lookupServices.getLoginDetails(loginData);

        assertNotNull(result);
        assertEquals("success", result.getResponse());
    }

    @Test
    public void testGetLoginDetails_FailedLogin() throws Exception {
        LoginData loginData = new LoginData("John", "john@example.com", 4, "Active", "Business", "User", "Yes", "john123", "password", null);
        when(lookupDao.getUserDetails(any())).thenReturn(loginData);

        LoginData result = lookupServices.getLoginDetails(loginData);

        assertNotNull(result);
        assertEquals("failed_login_response", result.getResponse());
    }

    // Add more test cases for different scenarios in getLoginDetails method

    @Test
    public void testSignupRequest_Success() throws Exception {
        LoginData loginData = new LoginData("John", "john@example.com", 0, "Active", "Business", "User", "Yes", "john123", "password", null);
        when(lookupDao.CheckValidLogin(any())).thenReturn(true);
        when(lookupDao.signupPerson(any())).thenReturn(loginData);

        LoginData result = lookupServices.signupRequest(loginData);

        assertNotNull(result);
        assertEquals("user_registered_successfully", result.getResponse());
    }

    @Test
    public void testSignupRequest_UserExists() throws Exception {
        LoginData loginData = new LoginData("John", "john@example.com", 0, "Active", "Business", "User", "Yes", "john123", "password", null);
        when(lookupDao.CheckValidLogin(any())).thenReturn(false);

        LoginData result = lookupServices.signupRequest(loginData);

        assertNotNull(result);
        assertEquals("user_already_exists", result.getResponse());
    }

    // Add more test cases for different scenarios in signupRequest method
}
