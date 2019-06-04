package Maverick_parking.model;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import Maverick_parking.data.SystemUserDAO;

public class CreateUserProfile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String permitType = "";
	private String address = "";
	private String carLicense = "";
	private String creditCard = "";
	private String phone = "";
	private String utaId = "";
	
	public String getPermitType() {
		return permitType;
	}
	public void setPermitType(String permitType) {
		this.permitType = permitType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCarLicense() {
		return carLicense;
	}
	public void setCarLicense(String carLicense) {
		this.carLicense = carLicense;
	}
	public String getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUtaId() {
		return utaId;
	}
	public void setUtaId(String utaId) {
		this.utaId = utaId;
	}
	public void validateFunction(String creditCard,String Phone,String carLicense,String Id,CreateUserProfileErrorMsgs err){
		CreateUserProfile user = new CreateUserProfile();
		user.setCreditCard(creditCard);
		user.setCarLicense(carLicense);
		user.setPhone(Phone);
		user.setUtaId(Id);
		validateCreditCard(user,err);
		validateCarLicense(user,err);
		validatePhoneNumber(user,err);
		validateUtaId(user,err);
		
	}
	public void validateCreditCard(CreateUserProfile systemUser, CreateUserProfileErrorMsgs createError) {
		String res = "";
		String cc = systemUser.getCreditCard();
		final String CC_PATTERN = "\\d{16}";
		Pattern pattern = Pattern.compile(CC_PATTERN);
		Matcher matcher = pattern.matcher(cc);
		if(cc.equals("")){
			res = "The Credit Card Field cannot be empty";
		}
		else if(cc.length()<16){
			res = "The Credit Card must be 16 digits";
		}
		
		else if(!matcher.matches()){
			res = "Invalid Credit Card";
		}
	
		createError.setCreditCardError(res);
		createError.setErrorMsg();
	}
	  
	public void validatePhoneNumber(CreateUserProfile systemUser, CreateUserProfileErrorMsgs createError) {
		String res = "";
		String pn = systemUser.getPhone();
		final String PN_PATTERN = "\\d{10}";
		Pattern pattern = Pattern.compile(PN_PATTERN);
		Matcher matcher = pattern.matcher(pn);
		if(pn.equals("")){
			res = "The Phone number Field cannot be empty";
		}
		else if(pn.length()<10){
			res = "The Phone number must be 10 digits";
		}
		
		else if(!matcher.matches()){
			res = "Invalid Phone number";
		}
		
		createError.setPhoneNumberError(res);
		createError.setErrorMsg();
	}
	public void validateUtaId(CreateUserProfile systemUser, CreateUserProfileErrorMsgs createError) {
		String res = "";
		String uta = systemUser.getUtaId();
		final String UTA_PATTERN = "\\d{10}";
		Pattern pattern = Pattern.compile(UTA_PATTERN);
		Matcher matcher = pattern.matcher(uta);
		if(uta.equals("")){
			res = "The UTA ID number cannot be empty";
		}
		else if(uta.length()<10){
			res = "The UTA ID must be 10 digits";
		}
		
		else if(!matcher.matches()){
			res = "Invalid UTA ID";
		}
		
		createError.setUtaIdError(res);
		createError.setErrorMsg();
	}
	
	
	public void validateCarLicense(CreateUserProfile systemUser, CreateUserProfileErrorMsgs createError) {
		String res = "";
		String cl = systemUser.getCarLicense();
		final String CL_PATTERN = "[a-zA-Z]{3}\\d{4}";
		Pattern pattern = Pattern.compile(CL_PATTERN);
		Matcher matcher = pattern.matcher(cl);
		if(cl.equals("")){
			res = "The Car License number cannot be empty";
		}
		else if(cl.length()<7){
			res = "The Car License number must be 7 digits";
		}
		
		else if(!matcher.matches()){
			res = "Invalid Car License Number";
		}
		
		createError.setCarLicenseError(res);
		createError.setErrorMsg();
	}
	}

