package Maverick_parking.model;

import java.io.Serializable;

public class ActivateUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName = "";
	private String name = "";
	private String status = "";
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
		

}
