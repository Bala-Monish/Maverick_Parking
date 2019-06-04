package Maverick_parking.data;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Maverick_parking.model.ReservationDetails;
import Maverick_parking.model.SpotDetails;
import Maverick_parking.util.SQLConnection;

public class ReservationDetailsDAO {
	static SQLConnection DBMgr = SQLConnection.getInstance();
	
	public static boolean exist(ReservationDetails reservationDetails) throws SQLException{
		Connection conn = DBMgr.getDBConnection();
		try{
			String spotPresent = "select reservation_id from reservation where reservation_id = "+reservationDetails.getReservation_id()+"";
			PreparedStatement stmt = conn.prepareStatement(spotPresent);
			ResultSet results = stmt.executeQuery();
			if(results.first()){
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static boolean checkstart_time(ReservationDetails reservationDetails) throws SQLException{
		Connection conn = DBMgr.getDBConnection();
		
		try{
			String spotPresent = "select start_time from reservation where reservation_id = "+reservationDetails.getReservation_id()+"";
			PreparedStatement stmt = conn.prepareStatement(spotPresent);
			ResultSet results = stmt.executeQuery();
			if(results.first()){
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				Date d1 = (Date) sdf.parse(reservationDetails.getStart_time());
				Date d2 = sdf.parse(results.getString("start_time"));
				int compareto = d1.compareTo(d2);
				if(compareto > 0){
					return true;
				}	
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static void updateReservation(ReservationDetails details){
		try{
			Connection con = DBMgr.getDBConnection();
			int time = Integer.parseInt(details.getDuration());
			
			String update = "Update reservation Set start_time='"+details.getStart_time()+"',duration='"+details.getDuration()+"' WHERE reservation_id ="+details.getReservation_id()+"";
			con=SQLConnection.getDBConnection();
			con.setAutoCommit(false);
			Statement stmt = con.createStatement();
			stmt.executeUpdate(update);
			con.commit();
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static boolean checkDuration(ReservationDetails reservationDetails) throws SQLException{
		Connection conn = DBMgr.getDBConnection();
		int duration = 0;
		try{
			String spotPresent = "select duration from reservation where reservation_id = "+reservationDetails.getReservation_id()+"";
			PreparedStatement stmt = conn.prepareStatement(spotPresent);
			ResultSet results = stmt.executeQuery();
			if(results.first()){
				duration = Integer.parseInt(results.getString("duration"));
				if((duration >= 15) && (duration < 180)){
					return true;
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static List<ReservationDetails> getReservationDetails(ReservationDetails reservationDetails){
		List<ReservationDetails> reservations = new ArrayList<ReservationDetails>();
		try{
			Connection con = DBMgr.getDBConnection();
			String searchspots = "select reservation_id,duration,start_time,end_time from reservation where reservation_id = "+reservationDetails.getReservation_id()+"";
			PreparedStatement stmt = con.prepareStatement(searchspots);
			ResultSet rs= stmt.executeQuery();
			while(rs.next()){
				ReservationDetails reservationinfo = new ReservationDetails();
				reservationinfo.setReservation_id(Integer.parseInt(rs.getString("reservation_id")));
				reservationinfo.setDuration(rs.getString("duration"));
				reservationinfo.setStart_time(rs.getString("start_time"));
				reservationinfo.setEnd_time(rs.getString("end_time"));
				reservations.add(reservationinfo);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return reservations;
	}

	public static void deleteReservation(ReservationDetails reservationDetails) {
		try{
			Connection con = DBMgr.getDBConnection();
			String deleteres = "delete from reservation where reservation_id="+reservationDetails.getReservation_id()+"";
			con=SQLConnection.getDBConnection();
			con.setAutoCommit(false);
			Statement stmt = con.createStatement();
			stmt.executeUpdate(deleteres);
			con.commit();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
