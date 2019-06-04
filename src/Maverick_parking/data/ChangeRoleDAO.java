package Maverick_parking.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Maverick_parking.model.ChangeRole;
import Maverick_parking.util.SQLConnection;

public class ChangeRoleDAO {
	static SQLConnection DBMgr = SQLConnection.getInstance();
	public static void change(ChangeRole systemUser) throws NoSuchFieldException, SecurityException{
		Statement stmt = null; 
		Connection conn = DBMgr.getDBConnection();
		//Connection conn = null;
		String insertUserQuery = "UPDATE system_user SET role_type = '"+systemUser.getRoleType()+"' WHERE user_name = '"+systemUser.getUserName()+"'";
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
	public static boolean exist(String user) throws SQLException{
		Connection conn = DBMgr.getDBConnection();
		try{
			
		
		String hasuser = "Select name from system_user where user_name ='"+user+"'";
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
	public static boolean check(ChangeRole user) throws SQLException{
		Connection conn = DBMgr.getDBConnection();
	try{
		
	
		String dbrole = "Select role_type from system_user where user_name = '"+user.getUserName()+"'";
		PreparedStatement stmt = conn.prepareStatement(dbrole);
		ResultSet results = stmt.executeQuery();
		while(results.next()){
			
		
		String db = results.getString("role_type");
		String choice = user.getRoleType();
		
		if(!db.contentEquals(choice)){
			return true;
		}
		else if(db.contentEquals(""))
		{
			return false;
		}
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	return false;
	}
}