package Maverick_parking.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Maverick_parking.model.Login;
import Maverick_parking.util.SQLConnection;

public class AccountStatusDAO {
	static SQLConnection DBMgr = SQLConnection.getInstance();
	public static String userStatus(Login detail) throws SQLException{
		String status = "";
		//String<AccountStatus> status = new String<AccountStatus>();
		Connection conn = DBMgr.getDBConnection();
		String searchquery = "Select account_status from system_user "
				+ "where user_name ='"+detail.getUserName()+"'";
		PreparedStatement stmt = conn.prepareStatement(searchquery);
		ResultSet results = stmt.executeQuery();
		while(results.next()){
			status = results.getString("account_status");
		}
		return status;
}
}
