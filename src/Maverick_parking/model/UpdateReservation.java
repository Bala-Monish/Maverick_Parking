package Maverick_parking.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class UpdateReservation {
	private String startTime = "";
	private String duration = "";
	private String history = "";
	private String cart = "";
	private String camera = "";
	private String endTime = "";
	private String totalCost = "";
	private String cardNumber = "";
	private String reservationID = "";
	
	
	public String getEndTime() {
		return endTime;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		if(history!=null)
		this.history = history;
		else
			this.history="";
	}
	public String getCart() {
		return cart;
	}
	public void setCart(String cart) {
		if(cart!=null)
		this.cart = cart;
		else
			this.cart = "";
	}
	public String getCamera() {
		return camera;
	}
	public void setCamera(String camera) {
		if(camera!=null)
		this.camera = camera;
		else
			camera = "";
	}
	public void setEndTime(String endTime){
		this.endTime = endTime;
	}

	
	public String getEndTime(String st,String du){
		//st = "01:01:00"; du = "75";
		String time[] = st.split(":");
		int min = Integer.parseInt(time[1])+Integer.parseInt(du);
		int hr = Integer.parseInt(time[0]);
		if(min>59&&min<120){
			min = min-60;
			hr++;
			if(hr>23)
				hr = hr-24;
		}
		else if(min>119&&min<180){
			min = min-120;
			hr+=2;
			if(hr>23)
				hr = hr-24;
		}
		else if(min>179){
			min = min-180;
			hr+=3;
			if(hr>23)
				hr = hr-24;
		}
		if(hr<10&&min<10)
			return "0"+hr+":"+"0"+min+":"+"00";
		else if(hr<10)
			return "0"+hr+":"+min+":"+"00";
		else if(min<10)
			return hr+":"+"0"+min+":"+"00";
		else
			return hr+":"+min+":"+"00";
	}
	public static double round(double value, int places) {
	    

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	public String calculateTotalCost(String ca,String crt,String h){
		double totalCost = 0.0;
		String op[] = {ca,crt,h};
		for(String s:op){
			if(!s.equals("")&&s!=null){
				totalCost += Double.parseDouble(s);
			}
		}
		totalCost = totalCost + 0.0825*totalCost;
		totalCost = round(totalCost,2);
		return "$"+Double.toString(totalCost);
	}
	public String getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getReservationID() {
		return reservationID;
	}
	public void setReservationID(String reservationID) {
		this.reservationID = reservationID;
	}

}
