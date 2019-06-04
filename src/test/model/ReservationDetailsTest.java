package test.model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import Maverick_parking.model.ReservationDetails;
import Maverick_parking.model.ReservationDetailsErrorMsgs;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class ReservationDetailsTest {
	ReservationDetails reserve;
	ReservationDetailsErrorMsgs error;
	@Before
	public void setUp() throws Exception {
		reserve = new  ReservationDetails();
		error  = new ReservationDetailsErrorMsgs();
	}

	@Test
	@FileParameters("src/test/model/ReservationDetailsData.csv")
	public void test(int testcase,int id,String Start,String duration,String idError,
			String durationError,String startError) throws SQLException {
		reserve.validateFunction(id, duration, Start, error);
		assertEquals(idError,error.getReservationDetailerror());
		assertEquals(durationError,error.getReservationDurationerror());
		assertEquals(startError,error.getReservationStarttimeerror());
	}

}
