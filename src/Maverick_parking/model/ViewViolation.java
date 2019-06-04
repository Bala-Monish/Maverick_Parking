package Maverick_parking.model;

import java.io.Serializable;

public class ViewViolation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String noShow = "";
	private String overdue = "";
	
	public String getNoShow() {
		return noShow;
	}
	public void setNoShow(String noShow) {
		this.noShow = noShow;
	}
	public String getOverdue() {
		return overdue;
	}
	public void setOverdue(String overdue) {
		this.overdue = overdue;
	}
	
}
