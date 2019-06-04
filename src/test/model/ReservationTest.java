package test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import Maverick_parking.model.Reservation;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class ReservationTest {
	Reservation reservation;

	@Before
	public void setUp() throws Exception {
		reservation = new Reservation();
	}

	@Test
	@FileParameters("src/test/model/ReservationTestCsv.csv")
	public void test(int testCaseNumber,String startTime,String duration,String endTime) {
		assertTrue(endTime.equals(reservation.getEndTime(startTime, duration)));
		
	}

}
