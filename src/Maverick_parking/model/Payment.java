package Maverick_parking.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Maverick_parking.data.ReservationDAO;
import Maverick_parking.data.SystemUserDAO;

public class Payment {
	private String totalCost = "";
	private String camera = "";
	private String cart = "";
	private String history = "";
	private String cardNumber = "";
	
	public String getCamera() {
		return camera;
	}
	
	public void validatePayment(String userName,String startTime, String camera,String cart,String history,ReservationErrorMsgs errorMsgs,String permitType,String accessType){
		
		totalCost = calculateTotalCost(getCamera(),getCart(),getHistory());
		validateAccessTypeForUser(permitType, accessType, errorMsgs);
//		validateReservationTimeWindowForUser(startTime, userName, errorMsgs);
		validateUserAccountStatus(userName, errorMsgs);
		validateCartTimings(startTime);
		
		
	}

	public void setCamera(String camera) {
		if(camera!=null)
		this.camera = camera;
		else
			this.camera="";
	}

	public String getCart() {
		return cart;
	}

	public void setCart(String cart) {
		if(cart!=null)
		this.cart = cart;
		else this.cart = "";
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		if(history!=null)
		this.history = history;
		else this.history = "";
	}

	


	public String getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}
	
	public static double round(double value, int places) {
	   // if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	public String calculateTotalCost(String ca,String crt,String h){
		double totalCost = 0.0;
		String op[] = {ca,crt,h};
		for(String s:op){
			if(!s.equals(""))
				totalCost += Double.parseDouble(s);
			}
		totalCost = totalCost + 0.0825*totalCost;
		totalCost = round(totalCost,2);
		return "$"+Double.toString(totalCost);
	}
	public void validateAccessTypeForUser(String permitType,String accessType ,ReservationErrorMsgs reservationErrorMsgs){
		HashMap<String,Integer> hm = new HashMap<String,Integer>();
		hm.put("Access", 1);
		hm.put("Premium",2);
		hm.put("Midrange",3);
		hm.put("Basic", 4);
		if(!permitType.equals("")){
			
		if(hm.get(permitType)>hm.get(accessType))
			reservationErrorMsgs.setErrorMsg("Cannot Reserve this spot with the Current permit type.Please upgrade your parking pass");
		}
			else
				reservationErrorMsgs.setErrorMsg("Please create a user profile before reserving a spot!");	
		
		
	}
	/*public void validateReservationTimeWindowForUser(String startTime,String userName,ReservationErrorMsgs reservationErrorMsgs){
		List<Integer> l = new ArrayList<Integer>();
		
			l = ReservationDAO.getTimeWidowFromDb(startTime, userName);
			if(!l.isEmpty()){
				reservationErrorMsgs.setTimeWindowErrorMsg("There is already a reservation in this time window.please choose a different time");
			}
			
		}
	*/
	public void validateUserAccountStatus(String userName,ReservationErrorMsgs reservationErrorMsgs){
		String accountStatus = SystemUserDAO.getAccountStatusFromDb(userName);
		
			if(!accountStatus.equals("Active"))
				reservationErrorMsgs.setUserRevokedErrorMsg("Cannot Make Reservation!The account status is revoked!!");
				
		/*
		else{
			reservationErrorMsgs.setUserRevokedErrorMsg("Cannot Make Resevation, as the account status is invalid!!");
		}*/
	}
	public boolean validateCartTimings(String startTime){
		String st[] = startTime.split(":");
		int stHr = Integer.parseInt(st[0]);
		if(stHr<6||stHr>=20)
	      return false;		//reservationErrorMsgs.setCartErrorMsg("Cart timings are M-F 06 Hrs to 20 Hrs. Please uncheck cart option to continue ");
	return true;
	}
	
	

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

}
