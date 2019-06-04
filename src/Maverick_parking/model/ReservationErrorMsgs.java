package Maverick_parking.model;

public class ReservationErrorMsgs {
	private String errorMsg = "";
	private String timeWindowErrorMsg = "";
	private String userRevokedErrorMsg = "";
	private String cartErrorMsg = "";
	
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getTimeWindowErrorMsg() {
		return timeWindowErrorMsg;
	}

	public void setTimeWindowErrorMsg(String timeWindowErrorMsg) {
		this.timeWindowErrorMsg = timeWindowErrorMsg;
	}

	public String getUserRevokedErrorMsg() {
		return userRevokedErrorMsg;
	}

	public void setUserRevokedErrorMsg(String userRevokedErrorMsg) {
		this.userRevokedErrorMsg = userRevokedErrorMsg;
	}

	public String getCartErrorMsg() {
		return cartErrorMsg;
	}

	public void setCartErrorMsg(String cartErrorMsg) {
		this.cartErrorMsg = cartErrorMsg;
	}

}
