package test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import Maverick_parking.model.Payment;
import Maverick_parking.model.ReservationErrorMsgs;
import junitparams.FileParameters;
//import company_management.model.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class PaymentTest {
	Payment pay;
	ReservationErrorMsgs errMsgs;

	@Before
	public void setUp() throws Exception {
		pay = new Payment();
		errMsgs = new ReservationErrorMsgs();
	}

	@Test
	@FileParameters("src/test/model/PaymentTestCsv.csv")
	public void test(int testCaseNumber,String userName,String accessType,String permitType,String camera,String cart,String history,String expTotalCost,String accessTypeErrMsg,String timeWindowErrorMsg,String accStatusErrorMsg,boolean cartTiming,String startTime) {
		pay.validatePayment(userName, startTime, camera, cart, history, errMsgs, permitType, accessType);
		assertTrue(expTotalCost.equals(pay.calculateTotalCost(camera, cart, history)));
		//pay.validateAccessTypeForUser(permitType, accessType, errMsgs);
		assertTrue(accessTypeErrMsg.equals(errMsgs.getErrorMsg()));
		//pay.validateReservationTimeWindowForUser(startTime, userName, errMsgs);
		//assertTrue(timeWindowErrorMsg.equals(errMsgs.getTimeWindowErrorMsg()));
		assertTrue(accStatusErrorMsg.equals(errMsgs.getUserRevokedErrorMsg()));
		assertEquals(cartTiming,pay.validateCartTimings(startTime));
	}

}
