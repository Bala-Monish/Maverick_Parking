package test.model;

import static org.junit.Assert.*;
import java.sql.SQLException;
import junitparams.FileParameters;
import junitparams.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import Maverick_parking.model.ManagerSearch;

@RunWith(JUnitParamsRunner.class)
public class MangerSearchTest {
	ManagerSearch search;
	@Before
	public void setUp() throws Exception{
		search = new ManagerSearch();
	}
	@Test
	@FileParameters("src/test/model/AdminSearchData.csv")
	public void test(int testcase,String UserName,String expectedError) throws SQLException  {
		String actualErr = "";
		actualErr = search.validate(UserName);
		assertEquals(expectedError,actualErr);
		
	}

}
