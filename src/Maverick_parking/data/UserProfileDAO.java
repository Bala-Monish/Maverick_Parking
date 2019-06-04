package Maverick_parking.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import Maverick_parking.model.CreateUserProfile;
import Maverick_parking.model.Login;
import Maverick_parking.model.SystemUser;
import Maverick_parking.util.SQLConnection;

public class UserProfileDAO {
	static SQLConnection DBMgr = SQLConnection.getInstance();
	public static void create(CreateUserProfile systemUser,Login login) throws NoSuchFieldException, SecurityException{
		Statement stmt = null; 
		Connection conn = DBMgr.getDBConnection();
		//Connection conn = null;
		String insertUserQuery = "UPDATE system_user SET permit_type = '"+systemUser.getPermitType()+"'"+",address = '"+systemUser.getAddress()+"',phone ='"+systemUser.getPhone()+"',car_license = '"+systemUser.getCarLicense()
		+"',credit_card = '"+systemUser.getCreditCard()+"',account_status ='Active',uta_id = '"+systemUser.getUtaId()+"' WHERE user_name = '"+login.getUserName()+"'";
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
}
