package test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import Maverick_parking.model.SystemUser;
import Maverick_parking.model.SystemUserErrorMsgs;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
@RunWith(JUnitParamsRunner.class)
public class SystemUserTest {
	SystemUser user;
	SystemUserErrorMsgs error;
	@Before
	public void setUp() throws Exception {
		user = new SystemUser();
		error = new SystemUserErrorMsgs();
	}

	@Test
	@FileParameters("src/test/model/SystemUserData.csv")
	public void test(int testcase,String uname,String pass,String cpass,String Name,String err,String userErr
			,String pasErr,String cpasErr,String nameErr) {
		user.validateFunction(uname, pass, cpass, Name, error);
		assertEquals(err,error.getErrorMsg());
		assertEquals(cpasErr,error.getCpasswordError());
		assertEquals(nameErr,error.getNameError());
		assertEquals(pasErr,error.getPasswordError());
		assertEquals(userErr,error.getUserNameError());
	
	}

}
