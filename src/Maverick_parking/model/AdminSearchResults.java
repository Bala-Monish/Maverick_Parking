<<<<<<< HEAD
package Maverick_parking.model;

public class AdminSearchResults {
	private static final long serialVersionUID = 1L;
	private String userName = "";
	private String name = "";
	private String address = "";
	private String phone = "";
	private String carLicense = "";
	private String accountStatus = "";
	private String permitType = "";
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCarLicense() {
		return carLicense;
	}
	public void setCarLicense(String carLicense) {
		this.carLicense = carLicense;
	}
	public String getPermitType() {
		return permitType;
	}
	public void setPermitType(String permitType) {
		this.permitType = permitType;
	}
	
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		if(accountStatus!=null){
		if (accountStatus.equals("1"))
		{
		this.accountStatus = "Active";
		}
		else if(accountStatus.equals("0"))
		{
			this.accountStatus = "Revoked";
		}
		}
		else
		{
			this.accountStatus ="";
		}
		
	
	}
	

}
=======
package Maverick_parking.model;

public class AdminSearchResults {
	private static final long serialVersionUID = 1L;
	private String userName = "";
	private String name = "";
	private String address = "";
	private String phone = "";
	private String carLicense = "";
	private String accountStatus = "";
	private String permitType = "";
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCarLicense() {
		return carLicense;
	}
	public void setCarLicense(String carLicense) {
		this.carLicense = carLicense;
	}
	public String getPermitType() {
		return permitType;
	}
	public void setPermitType(String permitType) {
		this.permitType = permitType;
	}
	
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		if(accountStatus!=null){
		if (accountStatus.equals("1"))
		{
		this.accountStatus = "Active";
		}
		else if(accountStatus.equals("0"))
		{
			this.accountStatus = "Revoked";
		}
		}
		else
		{
			this.accountStatus ="";
		}
		
	
	}
	

}
>>>>>>> 33b67b3d4164e7ba319bd54766d6748fb733209b
