package Maverick_parking.data;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Maverick_parking.model.SpotDetails;
import Maverick_parking.util.SQLConnection;

public class SpotDetailsDAO {
	static SQLConnection DBMgr = SQLConnection.getInstance();
	
	
	public static boolean exist(SpotDetails spotDetails) throws SQLException{
		Connection conn = DBMgr.getDBConnection();
		try{
			String spotPresent = "select spot_id from parking_spots where spot_id = "+spotDetails.getSpot_id()+"";
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
	
	public static List<SpotDetails> getSpotDetails(SpotDetails spotDetails){
		List<SpotDetails> spots = new ArrayList<SpotDetails>();
		try{
			Connection con = DBMgr.getDBConnection();
			String searchspots = "select spot_id,parea_name,permit_type,is_available from parking_spots where spot_id = "+spotDetails.getSpot_id()+"";
			PreparedStatement stmt = con.prepareStatement(searchspots);
			ResultSet rs= stmt.executeQuery();
			while(rs.next()){
				SpotDetails spotinfo = new SpotDetails();
				spotinfo.setSpot_id(Integer.parseInt(rs.getString("spot_id")));
				spotinfo.setParea_name(rs.getString("parea_name"));
				spotinfo.setPermit_type(rs.getString("permit_type"));
				spotinfo.setIs_available(rs.getString("is_available"));
				spots.add(spotinfo);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return spots;
	}
	
	public static void updateAvailability(int spotid,String Availability){
		try{
			Connection con = DBMgr.getDBConnection();
			String update = "Update parking_spots Set is_available='"+Availability+"' WHERE spot_id ="+spotid+"";
			con=SQLConnection.getDBConnection();
			con.setAutoCommit(false);
			Statement stmt = con.createStatement();
			stmt.executeUpdate(update);
			con.commit();
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
