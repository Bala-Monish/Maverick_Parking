package Maverick_parking.model;

public class Reservation {
	private String userName = "";
	private String startTime = "";
    private String endTime = "";
    private String duration = "";
    private String permitType = "";
    private String parkingAreaName = "";
    private String availableSpots = "";
    private String floor = "";

    //Getters and Setters
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getParkingAreaName() {
		return parkingAreaName;
	}
	public void setParkingAreaName(String parkingAreaName) {
		this.parkingAreaName = parkingAreaName;
	}

	public String getPermitType() {
		return permitType;
	}
	public void setPermitType(String permitType) {
		this.permitType = permitType;
	}
	public String getAvailableSpots() {
		return availableSpots;
	}
	public void setAvailableSpots(String availableSpots) {
		this.availableSpots = availableSpots;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
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
}
