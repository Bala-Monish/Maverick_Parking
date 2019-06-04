package Maverick_parking.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Maverick_parking.model.Login;
import Maverick_parking.model.PayAndReserve;
import Maverick_parking.model.ViewReservation;
import Maverick_parking.util.SQLConnection;

public class ReservationDAO {
	static SQLConnection DBMgr = SQLConnection.getInstance();
	
	public static void reserve(PayAndReserve pr){
		Statement stmt = null;   
		Connection conn = null;
		String subQuery = "select min(spot_id) from parking_spots where parea_name = '"+pr.getParkingAreaName()+"' AND permit_type = '"+pr.getPermitType()+"' AND is_available = 'Y'";
		
		try{
			conn = SQLConnection.getDBConnection();  
			stmt = conn.createStatement();
			
			ResultSet rs1 = stmt.executeQuery(subQuery);
			int spotID = 1 ;
			while(rs1.next()){
			spotID= rs1.getInt(1);
			}
			String query = "insert into reservation (user_name,spot_id,duration,start_time,"
					+ "end_time,camera,history,cart,total_cost) values ('"+pr.getUserName()+"',"+spotID+",'"+
					pr.getDuration()+"','"+pr.getStartTime()+"','"+pr.getEndTime()+"','"+pr.getCamera()+"','"+
					pr.getHistory()+"','"+pr.getCart()+"','"+pr.getTotalCost()+"')";
			stmt.executeUpdate(query);
			String query3 = "Update parking_spots set is_available = 'N' where spot_id = "+spotID;
			stmt.executeUpdate(query3);
			int cap = 0;
			String query4 = "SELECT pcapacity FROM parking_area where parea_name = (SELECT parea_name FROM parking_spots WHERE "
					+ "spot_id ="+spotID+") AND ptype = (SELECT permit_type FROM parking_spots WHERE spot_id = "+spotID+")";
			ResultSet rs2 = stmt.executeQuery(query4);
			while(rs2.next()){
				cap= rs2.getInt(1);
				}
			cap = cap -1;
			String query5 = "UPDATE parking_area set pcapacity ="+cap+" where parea_name = (SELECT parea_name FROM parking_spots WHERE "
					+ "spot_id ="+spotID+") AND ptype = (SELECT permit_type FROM parking_spots WHERE spot_id = "+spotID+")";
			stmt.executeUpdate(query5);
			conn.commit();
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
	}
	
	public static List<ViewReservation> viewReservation(Login un){
		
		List<ViewReservation> res_info = new ArrayList<ViewReservation>();
		try{
			
		
		Connection conn = DBMgr.getDBConnection();
		String searchquery = "Select reservation_id,spot_id,start_time,end_time,duration,camera,cart,history,total_cost from reservation "
				+ "where user_name ='"+un.getUserName()+"'";
		PreparedStatement stmt = conn.prepareStatement(searchquery);
		ResultSet results = stmt.executeQuery();
		while(results.next()){
			
			ViewReservation userdet = new ViewReservation();
			userdet.setReservationId(results.getString("reservation_id"));
			userdet.setSpotId(results.getString("spot_id"));
			userdet.setStartTime(results.getString("start_time"));
			userdet.setEndTime(results.getString("end_time"));
			userdet.setDuration(results.getString("duration"));
			userdet.setCamera(results.getString("camera"));
			userdet.setCart(results.getString("cart"));
			userdet.setHistory(results.getString("history"));
			userdet.setTotalCost(results.getString("total_cost"));
			res_info.add(userdet);
		
		}
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		return res_info;
}
	public static void cancelReservation(String reservationID,String spotID){
		Statement stmt = null;   
		Connection conn = null;
		int rid = Integer.parseInt(reservationID);
		int sid = Integer.parseInt(spotID);
		String query1 = "Delete from reservation where reservation_id = "+rid;
		String query2 = "Update parking_spots set is_available = 'Y' where spot_id ="+sid;

		try{
			conn = SQLConnection.getDBConnection();  
			stmt = conn.createStatement();
		    stmt.executeUpdate(query1);
		    stmt.executeUpdate(query2);
			
		    int cap = 0;
			String query4 = "SELECT pcapacity FROM parking_area where parea_name = (SELECT parea_name FROM parking_spots WHERE "
					+ "spot_id ="+sid+") AND ptype = (SELECT permit_type FROM parking_spots WHERE spot_id = "+sid+")";
			ResultSet rs2 = stmt.executeQuery(query4);
			while(rs2.next()){
				cap= rs2.getInt(1);
				}
			cap = cap +1;
			String query3 = "Update parking_area set pcapacity ="+cap+" where parea_name = (SELECT parea_name FROM parking_spots WHERE "
						+ "spot_id ="+sid+") AND ptype = (SELECT permit_type FROM parking_spots WHERE spot_id = "+sid+")";
		    stmt.executeUpdate(query3);
		    conn.commit();
		
	}catch(SQLException e){
		e.printStackTrace();
	}
	finally {
		try {
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}};
}
	public static void modifyReservation(String reservationID,String duration,String endTime,String camera,String cart,String history,String totalCost){
		Statement stmt = null;   
		Connection conn = null;
		int rid = Integer.parseInt(reservationID);
		int du = Integer.parseInt(duration);
		String query = "update reservation set duration ="+du+",end_time = '"+endTime+"',cart = '"+cart+"',camera = '"+camera+"',history = '"+history+"',total_cost='"+totalCost+"' where reservation_id = "+rid;
		try{
			conn = SQLConnection.getDBConnection();  
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			conn.commit();
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
		
		
	}
	public static List<Integer> getTimeWidowFromDb(String startTime, String userName){
		Statement stmt = null;   
		Connection conn = null;
		List<Integer> l = new ArrayList<Integer>();
		String query = "SELECT reservation_id from reservation where start_time <= '"+startTime+"' and end_time >='"+startTime+"' and user_name = '"+userName+"'";
		try{
			conn = SQLConnection.getDBConnection();  
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
		    while(rs.next()){
		    	l.add(rs.getInt(1));
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
			return l;
	}
	
}
