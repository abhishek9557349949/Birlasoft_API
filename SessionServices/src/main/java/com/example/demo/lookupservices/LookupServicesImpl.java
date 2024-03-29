package com.example.demo.lookupservices;
 
import java.sql.SQLException;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.example.demo.constants.LookupConstants;
import com.example.demo.entity.LoginData;
import com.example.demo.lookupdao.LookupDaoImpl;
 
 
@Service
public class LookupServicesImpl{
 
	@Autowired
    private static LookupDaoImpl lookupDao;
 
    public static LoginData getLoginDetails(LoginData loginDetails) throws Exception {
        try {
            LoginData loginResponseDetails = null;
            if (loginDetails.getUserId() != null && !loginDetails.getUserId().isBlank()
                    && loginDetails.getPassword() != null && !loginDetails.getPassword().isBlank()) {
                if (notValidLogin(loginDetails)) {
                    loginDetails.setResponse(LookupConstants.FAILED_LOGIN_RESPONSE);
                    return loginDetails;
                }
                loginResponseDetails = LookupDaoImpl.getUserDetails(loginDetails);
            } else {
                loginDetails.setResponse(LookupConstants.FAILED_LOGIN_RESPONSE);
            }
            return loginResponseDetails;
        }catch(Exception e){
         e.printStackTrace();
        }
        return null;
    }
 
    public static LoginData signupRequest(LoginData loginDetails) throws Exception {
        LoginData signupResponse = null;
        try{
            if(!checkValidUserId(loginDetails.getUserId())){
                signupResponse = new LoginData(
                        null, null, 0, null, null, null, null,
                        null, null, "User already exists");
            }else {
                signupResponse = lookupDao.signupPerson(loginDetails);
            }
        }catch(Exception e){
         e.printStackTrace();
        }
        return signupResponse;
    }
 
    private static boolean checkValidUserId(String userId) throws SQLException {
        if(userId.length() < 3){
            return false;
        }
        if(!lookupDao.CheckValidLogin(userId)){
            return false;
        };
        return true;
    }
 
    private static boolean notValidLogin(LoginData loginDetails) {
        if(loginDetails.getUserId().length() <= 3 || loginDetails.getPassword().length() <= 3){
            return true;
        }
        return false;
    }
}