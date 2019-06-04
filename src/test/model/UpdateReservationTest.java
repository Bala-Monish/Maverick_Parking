package test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import Maverick_parking.model.UpdateReservation;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
@RunWith(JUnitParamsRunner.class)
public class UpdateReservationTest {
   UpdateReservation updateReservation;
	@Before
	public void setUp() throws Exception {
		updateReservation = new UpdateReservation();
	}

	@Test
	@FileParameters("src/test/model/UpdateReservationTestCsv.csv")
	public void test(int testCaseNumber,String startTime,String duration,String expEndTime,String camera,String cart,String history,String expTotalCost) {
            assertTrue(expEndTime.equals(updateReservation.getEndTime(startTime,duration)));
            assertTrue(expTotalCost.equals(updateReservation.calculateTotalCost(camera, cart,history)));
      }

}
