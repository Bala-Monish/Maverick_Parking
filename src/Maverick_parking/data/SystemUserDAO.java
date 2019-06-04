<<<<<<< HEAD
package Maverick_parking.data;

import java.sql.Connection;
import java.sql.ResultSet;
//import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Maverick_parking.model.ActivateUser;
import Maverick_parking.model.Login;
import Maverick_parking.model.SystemUser;
import Maverick_parking.model.UpdateProfile;
import Maverick_parking.model.ViewViolation;
import Maverick_parking.util.SQLConnection;

public class SystemUserDAO {
	static SQLConnection DBMgr = SQLConnection.getInstance();
	public static void insertUser(SystemUser systemUser){
		Statement stmt = null;   
		Connection conn = DBMgr.getDBConnection();
		//Connection conn = null;
		String insertUserQuery = "INSERT INTO system_user (user_name,password,name,role_type) VALUES('"+systemUser.getUserName()
		+"',"+"'"+systemUser.getPassword()+"',"+"'"+systemUser.getName()+"',"+"'"
				+systemUser.getRoleType()+"')";
		try { 
			 
			conn = SQLConnection.getDBConnection();  
			conn.setAutoCommit(false);   
			stmt = conn.createStatement();
			stmt.executeUpdate(insertUserQuery);
			conn.commit();					 
		}catch (SQLException sqle) { 
			sqle.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			};
		
	}
	}
	public static boolean uniqueUserName(String userName){
		Statement stmt = null;   
		Connection conn = null;
		try{
			conn = SQLConnection.getDBConnection();  
			stmt = conn.createStatement();
			String query = "SELECT * FROM system_user WHERE user_name = '"+userName+"'";
			ResultSet rs = stmt.executeQuery(query);
			return rs.next();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}};
			return true;
	}
	public static boolean validateLoginCredentials(String userName,String password){
		Statement stmt = null;   
		Connection conn = null;
		try{
			conn = SQLConnection.getDBConnection();  
			stmt = conn.createStatement();
			String query = "SELECT * FROM system_user WHERE user_name = '"+userName+"' AND password = '"+password+"'";
			ResultSet rs = stmt.executeQuery(query);
			return rs.next();
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}};
			return false;
		
	}
	//This method to be called only after validating
	public static String getRoleTypeFromDb(String userName){
		Statement stmt = null;   
		Connection conn = null;
		String roleType = "";
		try{
			conn = SQLConnection.getDBConnection();  
			stmt = conn.createStatement();
			String query = "SELECT role_type FROM system_user WHERE user_name = '"+userName+"'";
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()){
				roleType = rs.getString(1);
			}
		
	}
		catch(SQLException e){
			e.printStackTrace();
		}
     return roleType;
   }
	
	public static String getPermitType(String userName){
		Statement stmt = null;   
		Connection conn = null;
		String accessType = "";
		try{
			conn = SQLConnection.getDBConnection();
			stmt = conn.createStatement();
			String query = "SELECT permit_type from system_user where user_name = '"+userName+"'";
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()){
				accessType = rs.getString("permit_type");
			}
		}
			catch(SQLException e){
				
			}
		finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}};
			return accessType;
		}
	
	public static String getCardNumberFromDb(String userName){
		Statement stmt = null;   
		Connection conn = null;
		String cardNumber = "";
		try{
			conn = SQLConnection.getDBConnection();
			stmt = conn.createStatement();
			String query = "SELECT credit_card from system_user where user_name = '"+userName+"'";
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()){
				cardNumber = rs.getString("credit_card");
			}
		}
			catch(SQLException e){
				
			}
		finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}};
			return cardNumber;
		}
	public static UpdateProfile getUserDetailsFromDb(String userName){
		Statement stmt = null;   
		Connection conn = null;
		String query = "SELECT * from system_user where user_name = '"+userName+"'";
		UpdateProfile up = new UpdateProfile();
		//List<UpdateProfile> l = new ArrayList<UpdateProfile>();
		try{
			conn = SQLConnection.getDBConnection();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()){
				
				up.setPassword(rs.getString("password"));
				up.setAddress(rs.getString("address"));
				up.setCarLicense(rs.getString("car_license"));
				up.setUtaId(rs.getString("uta_id"));
				up.setPermitType(rs.getString("permit_type"));
				up.setPhone(rs.getString("phone"));
				up.setCreditCard(rs.getString("credit_card"));
				//l.add(up);
			}
		}
                 catch(SQLException e){
				e.printStackTrace();
			}
		finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}};
			return up;
		
	}
	
	public static String getAccountStatusFromDb(String userName){
		Statement stmt = null;   
		Connection conn = null;
		String accountStatus = "";
		String query = "SELECT account_status from system_user where user_name = '"+userName+"'";
		try{
			conn = SQLConnection.getDBConnection();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				accountStatus = rs.getString("account_status");
			}
			}
		 catch(SQLException e){
				e.printStackTrace();
			}
		finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}};
		
	return accountStatus;
	}
	public static List<ActivateUser> getUsers(){
		Statement stmt = null;   
		Connection conn = null;
		List<ActivateUser> changeStatus = new ArrayList<ActivateUser>();
		try{
			conn = SQLConnection.getDBConnection();  
			stmt = conn.createStatement();
			
			String query = "SELECT user_name,name,account_status FROM system_user where role_type = 'User'";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				ActivateUser user = new ActivateUser();
				user.setUserName(rs.getString("user_name"));
				user.setName(rs.getString("name"));
				user.setStatus(rs.getString("account_status"));
				changeStatus.add(user);
			}
	}
		catch(SQLException e){
			e.printStackTrace();
		}
		return changeStatus;
	}
	
	public static List <String> getUsersForAdmitEdit(){
		Statement stmt = null;   
		Connection conn = null;
		List<String> userName = new ArrayList<String>();
		
		
		try{
			conn = SQLConnection.getDBConnection();  
			stmt = conn.createStatement();
			
			String query = "SELECT user_name FROM system_user where role_type = 'User'";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				String un = rs.getString("user_name");
				userName.add(un);
			}
	}
		catch(SQLException e){
			e.printStackTrace();
		}
		return userName;
		
	}
	public static void changeStatus(String uname){
		Statement stmt = null;   
		Connection conn = null;
		try{
			conn = SQLConnection.getDBConnection();  
			stmt = conn.createStatement();
			
			String query = "SELECT account_status FROM system_user where user_name = '"+uname+"'";
			ResultSet rs = stmt.executeQuery(query);
			if(rs.first()){
				String dbstatus = rs.getString("account_status");
				if (dbstatus.contentEquals("Active"))
				{
					String modify = "UPDATE system_user SET account_status = 'Revoked' where user_name ='"+uname+"'";
					stmt.executeUpdate(modify);
					conn.commit();
				}
				else
				{
					String modify = "UPDATE system_user SET account_status = 'Active'where user_name ='"+uname+"'";
					stmt.executeUpdate(modify);
					conn.commit();	
				}
				rs.close();
				}
			
	}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static void setNoShowForUser(String userName) {
		Statement stmt = null;   
		Connection conn = null;
		try{
			conn = SQLConnection.getDBConnection();  
			stmt = conn.createStatement();
			String query = "SELECT no_show from system_user where user_name = '"+userName+"'";
			int noShow = 0;
		    ResultSet rs = stmt.executeQuery(query);
		    while(rs.next()){
		    	noShow = rs.getInt("no_show");
		    }
		    noShow+=1;
		    if(noShow>=3){
		    String q2 = "UPDATE system_user set no_show = "+noShow+" Where user_name = '"+userName+"'";
		    stmt.executeUpdate(q2);
		    String q3 = "UPDATE system_user set account_status = 'Revoked' where user_name = '"+userName+"'";
		    stmt.executeUpdate(q3);
		    }
		    String q2 = "UPDATE system_user set no_show = "+noShow+" Where user_name = '"+userName+"'";
		    stmt.executeUpdate(q2);
		    conn.commit();
		    
	}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static void setOverStayForUser(String userName) {
		Statement stmt = null;   
		Connection conn = null;
		try{
			conn = SQLConnection.getDBConnection();  
			stmt = conn.createStatement();
			String query = "SELECT over_stay from system_user where user_name = '"+userName+"'";
			int overStay = 0;
		    ResultSet rs = stmt.executeQuery(query);
		    while(rs.next()){
		    	overStay = rs.getInt("over_stay");
		    }
		    overStay+=1;
		   
		    String q2 = "UPDATE system_user set over_stay = "+overStay+" Where user_name = '"+userName+"'";
		    stmt.executeUpdate(q2);
		    String q3 = "UPDATE system_user set account_status = 'Revoked' where user_name = '"+userName+"'";
		    stmt.executeUpdate(q3);
		    conn.commit();
		    
		    
	}
		catch(SQLException e){
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}
	
	public static List<ViewViolation> getViolation(Login uname){
		Statement stmt = null;   
		Connection conn = null;
		List<ViewViolation> viol = new ArrayList<ViewViolation>();
		try{
			conn = SQLConnection.getDBConnection();  
			stmt = conn.createStatement();
			
			String query = "SELECT no_show,over_stay FROM system_user where user_name = '"+uname.getUserName()+"'";
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()){
				ViewViolation count = new ViewViolation();
				count.setNoShow(rs.getString("no_show"));
				count.setOverdue(rs.getString("over_stay"));
				viol.add(count);
			}
	}catch(SQLException e){
		e.printStackTrace();
	}
		return viol;
	}
}

		


=======
package Maverick_parking.data;

import java.sql.Connection;
import java.sql.ResultSet;
//import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import Maverick_parking.model.SystemUser;
import Maverick_parking.util.SQLConnection;

public class SystemUserDAO {
	static SQLConnection DBMgr = SQLConnection.getInstance();
	public static void insertUser(SystemUser systemUser){
		Statement stmt = null;   
		Connection conn = DBMgr.getDBConnection();
		//Connection conn = null;
		String insertUserQuery = "INSERT INTO system_user (user_name,password,name,role_type) VALUES('"+systemUser.getUserName()
		+"',"+"'"+systemUser.getPassword()+"',"+"'"+systemUser.getName()+"',"+"'"
				+systemUser.getRoleType()+"')";
		try { 
			 
			conn = SQLConnection.getDBConnection();  
			conn.setAutoCommit(false);   
			stmt = conn.createStatement();
			stmt.executeUpdate(insertUserQuery);
			conn.commit();					 
		}catch (SQLException sqle) { 
			sqle.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			};
		
	}
	}
	public static boolean uniqueUserName(String userName){
		Statement stmt = null;   
		Connection conn = null;
		try{
			conn = SQLConnection.getDBConnection();  
			stmt = conn.createStatement();
			String query = "SELECT * FROM system_user WHERE user_name = '"+userName+"'";
			ResultSet rs = stmt.executeQuery(query);
			return rs.next();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}};
			return true;
	}
	public static boolean validateLoginCredentials(String userName,String password){
		Statement stmt = null;   
		Connection conn = null;
		try{
			conn = SQLConnection.getDBConnection();  
			stmt = conn.createStatement();
			String query = "SELECT * FROM system_user WHERE user_name = '"+userName+"' AND password = '"+password+"'";
			ResultSet rs = stmt.executeQuery(query);
			return rs.next();
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}};
			return false;
		
	}
	//This method to be called only after validating
	public static String getRoleTypeFromDb(String userName){
		Statement stmt = null;   
		Connection conn = null;
		String roleType = "";
		try{
			conn = SQLConnection.getDBConnection();  
			stmt = conn.createStatement();
			String query = "SELECT role_type FROM system_user WHERE user_name = '"+userName+"'";
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()){
				roleType = rs.getString(1);
			}
		
	}
		catch(SQLException e){
			e.printStackTrace();
		}
     return roleType;
   }
}
>>>>>>> 33b67b3d4164e7ba319bd54766d6748fb733209b
