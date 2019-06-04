package Maverick_parking.model;

public class CreateUserProfileErrorMsgs {

	private String errorMsg;
	private String phoneNumberError;
	private String utaIdError;
	private String creditCardError;
	private String carLicenseError;
	
	public  CreateUserProfileErrorMsgs(){
		this.phoneNumberError="";
		this.utaIdError="";
		this.creditCardError="";
		this.carLicenseError="";
	}
		public String getErrorMsg() {
			return errorMsg;
		}
		public void setErrorMsg() {
			if (!creditCardError.equals("") || !phoneNumberError.equals("") || !utaIdError.equals("") || !carLicenseError.equals(""))
				errorMsg="Please correct the following errors";
			else
				errorMsg="";
		}
	
	
	public String getCreditCardError() {
		return creditCardError;
	}
	public void setCreditCardError(String creditCardError) {
		this.creditCardError = creditCardError;
	}
	public String getPhoneNumberError() {
		return phoneNumberError;
	}
	public void setPhoneNumberError(String phoneNumberError) {
		this.phoneNumberError = phoneNumberError;
	}
	public String getUtaIdError() {
		return utaIdError;
	}
	public void setUtaIdError(String utaIdError) {
		this.utaIdError = utaIdError;
	}
	public String getCarLicenseError() {
		return carLicenseError;
	}
	public void setCarLicenseError(String carLicenseError) {
		this.carLicenseError = carLicenseError;
	}
	
	
	
	
		
	}
	


