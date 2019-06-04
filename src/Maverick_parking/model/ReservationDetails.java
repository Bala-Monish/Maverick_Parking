package Maverick_parking.model;

import java.io.Serializable;
import java.sql.SQLException;

import Maverick_parking.data.ReservationDetailsDAO;
import Maverick_parking.data.SpotDetailsDAO;

public class ReservationDetails implements Serializable {
	private int reservation_id=0;
	public int getReservation_id() {
		return reservation_id;
	}
	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getSpot_id() {
		return spot_id;
	}
	public void setSpot_id(int spot_id) {
		this.spot_id = spot_id;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getCamera() {
		return camera;
	}
	public void setCamera(String camera) {
		this.camera = camera;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public String getCart() {
		return cart;
	}
	public void setCart(String cart) {
		this.cart = cart;
	}
	
	private String user_name="";
	private int spot_id=0;
	private String duration = "";
	private String start_time = "";
	private String end_time = "";
	private String camera = "";
	private String history = "";
	private String cart = "";
	private String total_cost = "";
	
	
	public String getTotal_cost() {
		return total_cost;
	}
	public void setTotal_cost(String total_cost) {
		this.total_cost = total_cost;
	}
	public void validateFunction(int id,String duration,String start,ReservationDetailsErrorMsgs err) throws SQLException{
		ReservationDetails reserve = new ReservationDetails();
		reserve.setReservation_id(id);
		reserve.setDuration(duration);
		reserve.setStart_time(start);
		validate(reserve,err);
	}
	public void validate(ReservationDetails reservationDetails, ReservationDetailsErrorMsgs error) throws SQLException {
		String errmsg ="";
		String Durationerromsg="";
		String starttimemsg="";
		if(!ReservationDetailsDAO.exist(reservationDetails)){
			errmsg= "The reservationID is not present";
		}
		if(!ReservationDetailsDAO.checkstart_time(reservationDetails)){
			Durationerromsg = "Please enter a valid start time";
		}
		if(!ReservationDetailsDAO.checkDuration(reservationDetails)){
			starttimemsg="Please enter a valid duration";
		}
		error.setReservationDetailerror(errmsg);
		error.setReservationDurationerror(Durationerromsg);
		error.setReservationStarttimeerror(starttimemsg);
	}
	
	
}
