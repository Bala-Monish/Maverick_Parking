package Maverick_parking.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Maverick_parking.model.ParkingArea;
import Maverick_parking.model.SpotDetails;
import Maverick_parking.util.SQLConnection;

public class ParkingAreaDAO {
	static SQLConnection DBMgr = SQLConnection.getInstance();
	
	public static void insertArea(ParkingArea parkingarea){
		Connection conn = DBMgr.getDBConnection();
		Statement stmt=null;
		try{
			String query = "INSERT INTO parking_area(parea_name,floor,ptype,pcapacity) VALUES('"+parkingarea.getParea_name()+"','"+parkingarea.getFloor()+"','"+parkingarea.getPtype()+"',"+parkingarea.getPcapacity()+")";
			conn = SQLConnection.getDBConnection();  
			conn.setAutoCommit(false);   
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			conn.commit();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static List<ParkingArea> getSpotDetails(ParkingArea parkingarea){
		List<ParkingArea> parkinglist = new ArrayList<ParkingArea>();
		try{
			Connection con = DBMgr.getDBConnection();
			String searchspots = "select parea_name,floor,ptype,pcapacity from parking_area where parea_name = '"+parkingarea.getParea_name()+"'";
			PreparedStatement stmt = con.prepareStatement(searchspots);
			ResultSet rs= stmt.executeQuery();
			while(rs.next()){
				ParkingArea parking = new ParkingArea();
				parking.setParea_name(rs.getString("parea_name"));
				parking.setFloor(rs.getString("floor"));
				parking.setPcapacity(Integer.parseInt(rs.getString("pcapacity")));
				parking.setPtype(rs.getString("ptype"));
				parkinglist.add(parking);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return parkinglist;
	}

	public static boolean pareaexist(ParkingArea parkingarea) {
		Connection conn = DBMgr.getDBConnection();
		try{
			String spotPresent = "select parea_name from parking_area where parea_name = '"+parkingarea.getParea_name()+"'";
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

	public static boolean floorexist(ParkingArea parkingarea) {
		Connection conn = DBMgr.getDBConnection();
		try{
			String spotPresent = "select floor from parking_area where parea_name = '"+parkingarea.getParea_name()+"'";
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
	
	
	
	public static void updateSpots(ParkingArea parkingarea){
		try{
			Connection con = DBMgr.getDBConnection();
			String update = "Update parking_area Set pcapacity="+parkingarea.getPcapacity()+" WHERE parea_name ='"+parkingarea.getParea_name()+"' AND floor ='"+parkingarea.getFloor()+"'";
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
