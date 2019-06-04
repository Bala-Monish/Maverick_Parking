package test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import Maverick_parking.model.Login;
import Maverick_parking.model.LoginErrorMsgs;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;


@RunWith(JUnitParamsRunner.class)
public class LoginTest {
	Login login;
	LoginErrorMsgs loginErrorMsgs;

	@Before
	public void setUp() throws Exception {
		login = new Login();
		loginErrorMsgs = new LoginErrorMsgs();
	}

	@Test
	@FileParameters("src/test/model/LoginTestCsv.csv")
	public void test(int testCaseNumber,String userName,String password,String errorMsg) {
		
		login.validateLogin(userName, password, loginErrorMsgs);
		assertTrue(errorMsg.equals(loginErrorMsgs.getUserNamePasswordError()));
		
	
	
	}

}
