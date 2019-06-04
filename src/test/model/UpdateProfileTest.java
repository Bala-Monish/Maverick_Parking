package test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import Maverick_parking.model.UpdateProfile;
import Maverick_parking.model.UpdateProfileErrorMsgs;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
@RunWith(JUnitParamsRunner.class)
public class UpdateProfileTest {
	UpdateProfile profile;
	UpdateProfileErrorMsgs error;
	
	@Before
	public void setUp() throws Exception {
	profile = new UpdateProfile();
	error = new UpdateProfileErrorMsgs();
	
	}

	@Test
	@FileParameters("src/test/model/UpdateProfileData.csv")
	public void test(int testCaseNumber,String password,String creditCard,String phone,String utaID,String license,String errMsg,String passErr,String creditErr,String phErr,String utaErr,String licenseErr) {
		
		profile.validateFunction(password, creditCard, phone, license,utaID, error);
		assertEquals(errMsg,error.getErrorMsg());
		assertEquals(passErr,error.getPasswordError());
		assertEquals(creditErr,error.getCreditCardError());
		assertEquals(phErr,error.getPhoneNumberError());
		assertEquals(utaErr,error.getUtaIdError());
		assertEquals(licenseErr,error.getCarLicenseError());
		
		
	}

}
