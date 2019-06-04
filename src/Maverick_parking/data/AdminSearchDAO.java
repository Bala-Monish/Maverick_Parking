<<<<<<< HEAD
package Maverick_parking.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Maverick_parking.model.AdminSearch;
import Maverick_parking.model.AdminSearchResults;
import Maverick_parking.model.ManagerSearch;
import Maverick_parking.util.SQLConnection;

public class AdminSearchDAO {

	static SQLConnection DBMgr = SQLConnection.getInstance();
	public static List<AdminSearchResults> searchUser(AdminSearch admin_search) throws SQLException{
		
		List<AdminSearchResults> user_info = new ArrayList<AdminSearchResults>();
		Connection conn = DBMgr.getDBConnection();
		String searchquery = "Select user_name,name,address,phone,car_license,account_status,permit_type from system_user "
				+ "where user_name ='"+admin_search.getUname()+"'";
		PreparedStatement stmt = conn.prepareStatement(searchquery);
		ResultSet results = stmt.executeQuery();
		while(results.next()){
			
			AdminSearchResults userdet = new AdminSearchResults();
			userdet.setUserName(results.getString("user_name"));
			userdet.setName(results.getString("name"));
			userdet.setAddress(results.getString("address"));
			userdet.setPhone(results.getString("phone"));
			userdet.setCarLicense(results.getString("car_license"));
			userdet.setAccountStatus(results.getString("account_status"));
			userdet.setPermitType(results.getString("permit_type"));
			user_info.add(userdet);
		
		}
		return user_info;
	}

public static boolean exist(String  userName) throws SQLException{
	Connection conn = DBMgr.getDBConnection();
	try{
		
	
	String hasuser = "Select name from system_user where user_name ='"+userName+"'";
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

import Maverick_parking.model.AdminSearch;
import Maverick_parking.model.AdminSearchResults;
import Maverick_parking.model.ManagerSearch;
import Maverick_parking.util.SQLConnection;

public class AdminSearchDAO {

	static SQLConnection DBMgr = SQLConnection.getInstance();
	public static List<AdminSearchResults> searchUser(AdminSearch admin_search) throws SQLException{
		
		List<AdminSearchResults> user_info = new ArrayList<AdminSearchResults>();
		Connection conn = DBMgr.getDBConnection();
		String searchquery = "Select user_name,name,address,phone,car_license,account_status,permit_type from system_user "
				+ "where user_name ='"+admin_search.getUname()+"'";
		PreparedStatement stmt = conn.prepareStatement(searchquery);
		ResultSet results = stmt.executeQuery();
		while(results.next()){
			
			AdminSearchResults userdet = new AdminSearchResults();
			userdet.setUserName(results.getString("user_name"));
			userdet.setName(results.getString("name"));
			userdet.setAddress(results.getString("address"));
			userdet.setPhone(results.getString("phone"));
			userdet.setCarLicense(results.getString("car_license"));
			userdet.setAccountStatus(results.getString("account_status"));
			userdet.setPermitType(results.getString("permit_type"));
			user_info.add(userdet);
		
		}
		return user_info;
	}

public static boolean exist(AdminSearch admin_search) throws SQLException{
	Connection conn = DBMgr.getDBConnection();
	try{
		
	
	String hasuser = "Select name from system_user where user_name ='"+admin_search.getUname()+"'";
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