<<<<<<< HEAD
package Maverick_parking.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Maverick_parking.model.ManagerSearch;
import Maverick_parking.model.SearchResults;
import Maverick_parking.util.SQLConnection;

public class ManagerSearchDAO {

	
	static SQLConnection DBMgr = SQLConnection.getInstance();
	public static List<SearchResults> searchUser(ManagerSearch manager_search){
		
		List<SearchResults> user_info = new ArrayList<SearchResults>();
		try{
			
		
		Connection conn = DBMgr.getDBConnection();
		String searchquery = "Select user_name,name,address,phone,car_license,account_status,permit_type from system_user "
				+ "where user_name ='"+manager_search.getUname()+"'";
		PreparedStatement stmt = conn.prepareStatement(searchquery);
		ResultSet results = stmt.executeQuery();
		while(results.next()){
			
			SearchResults userdet = new SearchResults();
			userdet.setUserName(results.getString("user_name"));
			userdet.setName(results.getString("name"));
			userdet.setAddress(results.getString("address"));
			userdet.setPhone(results.getString("phone"));
			userdet.setCarLicense(results.getString("car_license"));
			userdet.setAccountStatus(results.getString("account_status"));
			userdet.setPermitType(results.getString("permit_type"));
			user_info.add(userdet);
		
		}
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		return user_info;
		}
	public static boolean exist(ManagerSearch manager_search) throws SQLException{
		Connection conn = DBMgr.getDBConnection();
		try{
			
		
		String hasuser = "Select name from system_user where user_name ='"+manager_search.getUname()+"'";
		PreparedStatement stmt = conn.prepareStatement(hasuser);
		ResultSet results = stmt.executeQuery();
		if(results.first())
		{
			return true;
		}
	
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
		
}
=======
package Maverick_parking.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Maverick_parking.model.ManagerSearch;
import Maverick_parking.model.SearchResults;
import Maverick_parking.util.SQLConnection;

public class ManagerSearchDAO {

	
	static SQLConnection DBMgr = SQLConnection.getInstance();
	public static List<SearchResults> searchUser(ManagerSearch manager_search){
		
		List<SearchResults> user_info = new ArrayList<SearchResults>();
		try{
			
		
		Connection conn = DBMgr.getDBConnection();
		String searchquery = "Select user_name,name,address,phone,car_license,account_status,permit_type from system_user "
				+ "where user_name ='"+manager_search.getUname()+"'";
		PreparedStatement stmt = conn.prepareStatement(searchquery);
		ResultSet results = stmt.executeQuery();
		while(results.next()){
			
			SearchResults userdet = new SearchResults();
			userdet.setUserName(results.getString("user_name"));
			userdet.setName(results.getString("name"));
			userdet.setAddress(results.getString("address"));
			userdet.setPhone(results.getString("phone"));
			userdet.setCarLicense(results.getString("car_license"));
			userdet.setAccountStatus(results.getString("account_status"));
			userdet.setPermitType(results.getString("permit_type"));
			user_info.add(userdet);
		
		}
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		return user_info;
		}
	public static boolean exist(ManagerSearch manager_search) throws SQLException{
		Connection conn = DBMgr.getDBConnection();
		try{
			
		
		String hasuser = "Select name from system_user where user_name ='"+manager_search.getUname()+"'";
		PreparedStatement stmt = conn.prepareStatement(hasuser);
		ResultSet results = stmt.executeQuery();
		if(results.first())
		{
			return true;
		}
	
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
		
}
>>>>>>> 33b67b3d4164e7ba319bd54766d6748fb733209b
}