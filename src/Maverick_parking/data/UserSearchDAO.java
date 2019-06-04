<<<<<<< HEAD
package Maverick_parking.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Maverick_parking.model.UserSearch;
import Maverick_parking.model.UserSearchResults;
import Maverick_parking.util.SQLConnection;

public class UserSearchDAO {

	static SQLConnection DBMgr = SQLConnection.getInstance();
	public static List<UserSearchResults> searchPark(UserSearch user_search) throws SQLException{
		
		List<UserSearchResults> parking_info = new ArrayList<UserSearchResults>();
		Connection conn = DBMgr.getDBConnection();
		String searchquery;
		if((user_search.getPermitType()).equals("Basic"))
		{
			
		
			 searchquery = "Select parea_name,floor,ptype,pcapacity from parking_area "
				+ "where ptype LIKE '"+user_search.getPermitType()+"'";
		}
		else if((user_search.getPermitType()).equals("Midrange"))
		{
			 searchquery = "Select parea_name,floor,ptype,pcapacity from parking_area "
					+ "where ptype in ('Basic','Midrange')";
		}
		else if((user_search.getPermitType()).equals("Premium"))
		{
			 searchquery = "Select parea_name,floor,ptype,pcapacity from parking_area "
					+ "where ptype in ('Basic','Midrange','Premium')";
		}
		else 
		{
			searchquery = "Select parea_name,floor,ptype,pcapacity from parking_area ";
		}
		PreparedStatement stmt = conn.prepareStatement(searchquery);
		ResultSet results = stmt.executeQuery();
		while(results.next()){
			
			UserSearchResults userdet = new UserSearchResults();
			userdet.setParkingAreaName(results.getString("parea_name"));
			userdet.setFloor(results.getString("floor"));
			userdet.setParkingType(results.getString("ptype"));
			userdet.setPcapacity(results.getString("pcapacity"));
			parking_info.add(userdet);
		
		}
		return parking_info;
	}
}
=======
package Maverick_parking.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Maverick_parking.model.UserSearch;
import Maverick_parking.model.UserSearchResults;
import Maverick_parking.util.SQLConnection;

public class UserSearchDAO {

	static SQLConnection DBMgr = SQLConnection.getInstance();
	public static List<UserSearchResults> searchPark(UserSearch user_search) throws SQLException{
		
		List<UserSearchResults> parking_info = new ArrayList<UserSearchResults>();
		Connection conn = DBMgr.getDBConnection();
		String searchquery;
		if((user_search.getPermitType()).equals("Basic"))
		{
			
		
			 searchquery = "Select parea_name,floor,ptype,pcapacity from parking_area "
				+ "where ptype LIKE '"+user_search.getPermitType()+"'";
		}
		else if((user_search.getPermitType()).equals("Midrange"))
		{
			 searchquery = "Select parea_name,floor,ptype,pcapacity from parking_area "
					+ "where ptype in ('Basic','Midrange')";
		}
		else if((user_search.getPermitType()).equals("Premium"))
		{
			 searchquery = "Select parea_name,floor,ptype,pcapacity from parking_area "
					+ "where ptype in ('Basic','Midrange','Premium')";
		}
		else 
		{
			searchquery = "Select parea_name,floor,ptype,pcapacity from parking_area ";
		}
		PreparedStatement stmt = conn.prepareStatement(searchquery);
		ResultSet results = stmt.executeQuery();
		while(results.next()){
			
			UserSearchResults userdet = new UserSearchResults();
			userdet.setParkingAreaName(results.getString("parea_name"));
			userdet.setFloor(results.getString("floor"));
			userdet.setParkingType(results.getString("ptype"));
			userdet.setPcapacity(results.getString("pcapacity"));
			parking_info.add(userdet);
		
		}
		return parking_info;
	}
}
>>>>>>> 33b67b3d4164e7ba319bd54766d6748fb733209b
