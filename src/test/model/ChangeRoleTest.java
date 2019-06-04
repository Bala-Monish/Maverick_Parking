package test.model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import Maverick_parking.model.ChangeRole;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class ChangeRoleTest {
	ChangeRole change;
	@Before
	public void setUp() throws Exception {
		change = new ChangeRole();
	}

	@Test
	@FileParameters("src/test/model/ChangeRoleData.csv")
	public void test(int testcase,String UserName, String Role,String expectedErr) throws SQLException {
		String actErr = change.validateFunction(UserName,Role);
		assertEquals(expectedErr,actErr);
	}

}
