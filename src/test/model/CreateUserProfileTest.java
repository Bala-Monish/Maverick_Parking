package test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import Maverick_parking.model.CreateUserProfile;
import Maverick_parking.model.CreateUserProfileErrorMsgs;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
@RunWith(JUnitParamsRunner.class)
public class CreateUserProfileTest {
	CreateUserProfile user;
	CreateUserProfileErrorMsgs err;
	@Before
	public void setUp() throws Exception {
		user = new CreateUserProfile();
		err = new CreateUserProfileErrorMsgs();
	}

	
	@Test
	@FileParameters("src/test/model/CreateUserProfileData.csv")
	public void test(int testcase,String creditCard,String Phone,String UtaId,String carLicense,String creditErr,
			String phoneErr,String idErr,String carErr,String error) {
		user.validateFunction(creditCard, Phone, carLicense, UtaId,err);
		assertEquals(creditErr,err.getCreditCardError());
		assertEquals(carErr,err.getCarLicenseError());
		assertEquals(phoneErr,err.getPhoneNumberError());
		assertEquals(idErr,err.getUtaIdError());
		assertEquals(error,err.getErrorMsg());
	
	}

}
