package test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import Maverick_parking.model.ParkingArea;
import Maverick_parking.model.ParkingAreaErrorMsgs;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
@RunWith(JUnitParamsRunner.class)
public class ModifyAreaTest {

	ParkingArea park;
	ParkingAreaErrorMsgs error;
	
	@Before
	public void setUp() throws Exception {
		park = new ParkingArea();
		error = new ParkingAreaErrorMsgs();
	}

	@Test
	@FileParameters("src/test/model/ModifyAreaData.csv")
	public void test(int testcase,String Parea,String Ptype,String Floor,int cap,String pAreaError,String typeError,
			String floorError,String capError) {
		park.validateSecFunction(Parea, Floor, Ptype, cap, error);
		assertEquals(pAreaError,error.getParkingareanameerror());
		assertEquals(floorError,error.getFloorerror());
		assertEquals(capError,error.getPcapacityerror());
		assertEquals(typeError,error.getPtypeerror());
	}

}
