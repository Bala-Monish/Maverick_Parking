package Maverick_parking.model;

import java.io.Serializable;
import java.sql.SQLException;

import Maverick_parking.data.ParkingAreaDAO;
import Maverick_parking.data.SpotDetailsDAO;

public class ParkingArea implements Serializable {
	public String getParea_name() {
		return parea_name;
	}
	public void setParea_name(String parea_name) {
		this.parea_name = parea_name;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	public int getPcapacity() {
		return pcapacity;
	}
	public void setPcapacity(int pcapacity) {
		this.pcapacity = pcapacity;
	}
	private String parea_name ="";
	private String floor ="";
	private String ptype = "";
	private int pcapacity = 0;
	
	public void validateFunction(String PArea,String Floor,String Ptype,int cap,ParkingAreaErrorMsgs err){
		ParkingArea park = new ParkingArea();
		park.setFloor(Floor);
		park.setParea_name(PArea);
		park.setPcapacity(cap);
		park.setPtype(Ptype);
		validate(park,err);
		//validateexisting(park,err);
	}
	public void validateSecFunction(String PArea,String Floor,String Ptype,int cap,ParkingAreaErrorMsgs err){
		ParkingArea park = new ParkingArea();
		park.setFloor(Floor);
		park.setParea_name(PArea);
		park.setPcapacity(cap);
		park.setPtype(Ptype);
		validateexisting(park,err);
	}
	public void validate(ParkingArea parkingarea,ParkingAreaErrorMsgs error){
		String errmsg ="";
		String pareaerror = "";
		String capacityerror= "";
		String ptypeerror="";
		if(parkingarea.getFloor().equals("")){
			errmsg= "The Floor value is not present";
		}
		if(parkingarea.getParea_name().equals("")){
			pareaerror = "The parea value is not present";
		}
		if((parkingarea.getPcapacity()==0) || (parkingarea.getPcapacity()<0)){
			capacityerror = "The capacity value is not present";
		}
		if(parkingarea.getPtype().equals("")){
			ptypeerror = "Parking type is empty";
		}
		error.setFloorerror(errmsg);
		error.setParkingareanameerror(pareaerror);
		error.setPcapacityerror(capacityerror);
		error.setPtypeerror(ptypeerror);
	}
	public void validateexisting(ParkingArea parkingarea, ParkingAreaErrorMsgs error) {
		String errmsg ="";
		String pareaerror = "";
		String capacityerror= "";
		
		
		if(!ParkingAreaDAO.pareaexist(parkingarea)){
			pareaerror="Enter a valid parking area";
		}
		if(!ParkingAreaDAO.floorexist(parkingarea)){
			errmsg="Enter a valid existing floor";
		}
		if(parkingarea.getPcapacity()==0){
			capacityerror = "Capacity cannot be zero";
		}
		error.setPcapacityerror(capacityerror);
		error.setParkingareanameerror(pareaerror);
		error.setFloorerror(errmsg);
	}	

}
