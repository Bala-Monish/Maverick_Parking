package Maverick_parking.model;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UpdateProfile implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String password = "";
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void validateFunction(String pass,String creditCard,String phone,String carLicense,String UtaID,UpdateProfileErrorMsgs error){
		UpdateProfile profile = new UpdateProfile();
		profile.setCreditCard(creditCard);
		profile.setCarLicense(carLicense);
		profile.setPassword(pass);
		profile.setPhone(phone);
		profile.setUtaId(UtaID);
		validateUtaId(profile,error);
		validatePassword(profile,error);
		validateCreditCard(profile,error);
		validatePhoneNumber(profile,error);
		validateCarLicense(profile,error);
	}
	
	public void validatePassword(UpdateProfile user_profile, UpdateProfileErrorMsgs updateError) {
		String res = "";
		String pwd = user_profile.getPassword();boolean space = false;
		final String PWD_PATTERN =  "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#!$%^_&+=])(?=\\S+$).{6,18}";
		Pattern pattern = Pattern.compile(PWD_PATTERN);
		Matcher matcher = pattern.matcher(pwd);
		for(int i =0;i<pwd.length();i++){
			if(pwd.charAt(i)==' '){
				space = true;
				break;
			}
		}
		if(pwd.equals("")){
			res = "Password Field cannot be Empty";
		}
		else if(pwd.length()<6){
			res = "Password length must be at least 6 characters";
		}
		else if(pwd.length()>12){
			res = "Password length cannot exceed 12 characters";
		}
		else if(space){
			res = "password cannot contain blank space character";
		}
		else if(!matcher.matches()){
			res = "Invalid password it must contain at least 1 digit 1 lc 1 uc 1 sc";
		}
		updateError.setPasswordError(res);
		updateError.setErrorMsg();
	}
	public void validateCreditCard(UpdateProfile user_profile, UpdateProfileErrorMsgs updateError) {
		String res = "";
		String cc = user_profile.getCreditCard();
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
		
		updateError.setCreditCardError(res);
		updateError.setErrorMsg();
	}
	  
	public void validatePhoneNumber(UpdateProfile user_profile, UpdateProfileErrorMsgs updateError) {
		String res = "";
		String pn = user_profile.getPhone();
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
		
		updateError.setPhoneNumberError(res);
		updateError.setErrorMsg();
	}
	public void validateUtaId(UpdateProfile user_profile, UpdateProfileErrorMsgs updateError) {
		String res = "";
		String uta = user_profile.getUtaId();
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
		
		updateError.setUtaIdError(res);
		updateError.setErrorMsg();
	}
	//[a-zA-Z]{3}\d{4}
	
	public void validateCarLicense(UpdateProfile user_profile, UpdateProfileErrorMsgs updateError) {
		String res = "";
		String cl = user_profile.getCarLicense();
		final String CL_PATTERN = "[a-zA-Z]{3}\\d{4}";
		Pattern pattern = Pattern.compile(CL_PATTERN);
		Matcher matcher = pattern.matcher(cl);
		if(cl.equals("")){
			res = "The Car License number cannot be empty";
		}		
		else if(!matcher.matches()){
			res = "Invalid Car License Number";
		}
		
		updateError.setCarLicenseError(res);
		updateError.setErrorMsg();
	}
	}


