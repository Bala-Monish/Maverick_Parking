package test.model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import Maverick_parking.model.SpotDetails;
import Maverick_parking.model.SpotDetailsErrorMsgs;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
@RunWith(JUnitParamsRunner.class)
public class SpotDetailsTest {

	SpotDetails spot;
	SpotDetailsErrorMsgs error;
	@Before
	public void setUp() throws Exception {
		spot = new SpotDetails();
		error = new SpotDetailsErrorMsgs();
	}

	@Test
	@FileParameters("src/test/model/SpotDetailsData.csv")
	public void test(int testcase,int id,String expErr) throws SQLException {
		spot.validateFunction(id, error);
		assertEquals(expErr,error.getSpotDetailerror());
	}

}
