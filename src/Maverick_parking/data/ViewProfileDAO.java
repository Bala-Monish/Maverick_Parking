package Maverick_parking.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Maverick_parking.model.Login;
import Maverick_parking.model.ViewProfile;
import Maverick_parking.util.SQLConnection;

public class ViewProfileDAO {
	static SQLConnection DBMgr = SQLConnection.getInstance();
	public static List<ViewProfile> userDetails(Login detail) throws SQLException{
		
		List<ViewProfile> user_info = new ArrayList<ViewProfile>();
		Connection conn = DBMgr.getDBConnection();
		String searchquery = "Select * from system_user "
				+ "where user_name ='"+detail.getUserName()+"'";
		PreparedStatement stmt = conn.prepareStatement(searchquery);
		ResultSet results = stmt.executeQuery();
		while(results.next()){
			
			ViewProfile userdet = new ViewProfile();
			userdet.setName(results.getString("name"));
			userdet.setAddress(results.getString("address"));
			userdet.setPhone(results.getString("phone"));
			userdet.setCreditCard(results.getString("credit_card"));
			userdet.setCarLicense(results.getString("car_license"));
			userdet.setPermitType(results.getString("permit_type"));
			userdet.setUtaId(results.getString("uta_id"));
			user_info.add(userdet);
		
		}
		return user_info;
}
}
