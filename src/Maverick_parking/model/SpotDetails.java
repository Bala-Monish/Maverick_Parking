package Maverick_parking.model;

import java.io.Serializable;
import java.sql.SQLException;

import Maverick_parking.data.SpotDetailsDAO;

public class SpotDetails implements Serializable {
	
	private int spot_id=0;
	private String parea_name;
	private String permit_type;
	private String is_available;
	
	
	public int getSpot_id() {
		return spot_id;
	}
	public void setSpot_id(int spot_id) {
		this.spot_id = spot_id;
	}
	public String getParea_name() {
		return parea_name;
	}
	public void setParea_name(String parea_name) {
		this.parea_name = parea_name;
	}
	public String getPermit_type() {
		return permit_type;
	}
	public void setPermit_type(String permit_type) {
		this.permit_type = permit_type;
	}
	public String getIs_available() {
		return is_available;
	}
	public void setIs_available(String is_available) {
		this.is_available = is_available;
	}
	
	public void validateFunction(int id,SpotDetailsErrorMsgs err) throws SQLException{
		SpotDetails spot = new SpotDetails();
		spot.setSpot_id(id);
		validate(spot,err);
	}
	public void validate(SpotDetails spotDetails,SpotDetailsErrorMsgs error) throws SQLException{
		String errmsg ="";
		if(!SpotDetailsDAO.exist(spotDetails)){
			errmsg= "The SpotID is not present";
		}
		error.setSpotDetailerror(errmsg);
	}
	

}
