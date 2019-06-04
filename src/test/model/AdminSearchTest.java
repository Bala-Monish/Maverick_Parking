package test.model;

import static org.junit.Assert.*;
import java.sql.SQLException;
import junitparams.FileParameters;
import junitparams.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import Maverick_parking.model.AdminSearch;

@RunWith(JUnitParamsRunner.class)
public class AdminSearchTest {
	AdminSearch search;
	@Before
	public void setUp() throws Exception{
		search = new AdminSearch();
	}
	@Test
	@FileParameters("src/test/model/AdminSearchData.csv")
	public void test(int testcase,String UserName,String expectedError) throws SQLException  {
		String actualErr = "";
		actualErr = search.validate(UserName);
		assertEquals(expectedError,actualErr);
		
	}

}
