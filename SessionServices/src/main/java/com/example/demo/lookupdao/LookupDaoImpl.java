package com.example.demo.lookupdao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import org.springframework.stereotype.Service;
 
import com.example.demo.constants.LookupConstants;
import com.example.demo.encryptAndDecryptPassword.CypherText;
import com.example.demo.entity.LoginData;
import com.example.demo.repository.DBConnector;
import com.example.demo.repository.SQLString;
 
@Service
public class LookupDaoImpl{
    public static LoginData getUserDetails(LoginData loginData) throws Exception {
        String loginquerry = SQLString.loginString;
        Connection connection = DBConnector.getNewConnection();
        assert connection != null;
        PreparedStatement statement = connection.prepareStatement(loginquerry);
        statement.setString(1, loginData.getUserId());
        statement.setString(2, CypherText.encrypt(loginData.getPassword(), CypherText.stringToSecretKey(LookupConstants.ENCRYPTION_KEY)));
        ResultSet resultSet = statement.executeQuery();
 
        if (resultSet.next()) {
            LoginData loginInfo = new LoginData(
                    resultSet.getString("CLIENT_NAME"),
                    resultSet.getString("MAIL_ID"),
                    resultSet.getInt("FAILED_LOGIN_ATTEMPTS"),
                    resultSet.getString("ACCOUNT_STATUS"),
                    resultSet.getString("BUSINESS_NAME"),
                    resultSet.getString("ROLE"),
                    resultSet.getString("APPROVED_BY_OWNER"),
                    loginData.getUserId(),null,"success");
 
            if (!loginInfo.getAccountStatus().equalsIgnoreCase(LookupConstants.ACTIVE_ACCOUNT)
                    || loginInfo.getFailedLoginAttempts() > 300) {
                    loginInfo.setResponse(LookupConstants.FAILED_LOGIN_RESPONSE);
            }
            if(!loginInfo.getApprovedByOwner().equalsIgnoreCase(LookupConstants.YES_STRING)){
                loginInfo.setResponse(LookupConstants.FAILED_LOGIN_RESPONSE);
            }
            resultSet.close();
            statement.close();
            DBConnector.closeConnection(connection);
            return loginInfo;
        }else{
            String incorrectLogin = SQLString.incorrectLogin;
            PreparedStatement logoutStatement = connection.prepareStatement(incorrectLogin);
            logoutStatement.setString(1, loginData.getUserId());
            logoutStatement.executeUpdate();
            LoginData loginInfo = new LoginData(
                    null,null,0,null, null, null,null,
                    loginData.getUserId(),null,"Incorrect Password");
            return loginInfo;
        }
    }
 
    public static boolean CheckValidLogin(String userId) throws SQLException {
        try {
            String checkValidUser = SQLString.checkValidUser;
            Connection connection = DBConnector.getNewConnection();
            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(checkValidUser);
            statement.setString(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println(resultSet);
                resultSet.close();
                statement.close();
                DBConnector.closeConnection(connection);
                return false;
            } else {
                resultSet.close();
                statement.close();
                DBConnector.closeConnection(connection);
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
 
    public static LoginData signupPerson(LoginData loginDetails) throws Exception {
 
        Connection connection = DBConnector.getNewConnection();
        assert connection != null;
        String signupLogin = SQLString.signupLogin;
        PreparedStatement signupStatement = connection.prepareStatement(signupLogin);
        signupStatement.setString(1, CypherText.encrypt(loginDetails.getPassword(), CypherText.stringToSecretKey(LookupConstants.ENCRYPTION_KEY)));
        signupStatement.setString(2, loginDetails.getUserId());
        signupStatement.setString(3, loginDetails.getMailId());
        signupStatement.setString(4, loginDetails.getClientName());
        signupStatement.setInt(5, 0);
        signupStatement.setString(6, "Active");
        signupStatement.setString(7, loginDetails.getBusinessName());
        signupStatement.setString(8, loginDetails.getRole());
        int isupdated = signupStatement.executeUpdate();
        LoginData loginInfo;
        if (isupdated != 0) {
            loginDetails.setPassword(null);
            loginDetails.setResponse("user registered successfully");
            loginInfo = loginDetails;
 
        } else {
            loginInfo = new LoginData(
                    null, null, 0, null, null, null, null,
                    null, null, "there is some error please try again after some time");
        }
        signupStatement.close();
        DBConnector.closeConnection(connection);
        return loginInfo;
    }}