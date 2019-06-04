<<<<<<< HEAD
package Maverick_parking.model;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
public class UserSearch implements Serializable {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private String permitType = "";
			private String stHr = "";
			public String getStHr() {
				return stHr;
			}
			public void setStHr(String stHr) {
				this.stHr = stHr;
			}
			public String getStMin() {
				return stMin;
			}
			public void setStMin(String stMin) {
				this.stMin = stMin;
			}
			public String getDuration() {
				return duration;
			}
			public void setDuration(String duration) {
				this.duration = duration;
			}
			private String stMin = "";
			private String duration = "";
			public String getPermitType() {
				return permitType;
			}
			public void setPermitType(String permitType) {
				this.permitType = permitType;
			}
			public String getStartTime(String hr,String min){
				return hr+":"+min+":"+"00";
			}
			public void isSearchTimeLessThanCurrentTime(UserSearch userSearch,UserSearchErrorMsgs errorMsgs){
				
				
				
				int stHr = Integer.parseInt(userSearch.getStHr());
				int stMin = Integer.parseInt(userSearch.getStMin());
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				String currentTime = sdf.format(new Date());
				String ct[] = currentTime.split(":");
				int ctHr = Integer.parseInt(ct[0]);
				int ctMin = Integer.parseInt(ct[1]);
				if(stHr<ctHr)
					errorMsgs.setErrMsgTimeCompare("Start time cannot be less than System Current Time");
				else if(stHr==ctHr){
					if(stMin<ctMin)
						errorMsgs.setErrMsgTimeCompare("Start time cannot be less than System Current Time");
				}
				
			}



}
=======
package Maverick_parking.model;
import java.io.Serializable;
public class UserSearch implements Serializable {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private String permitType = "";
			public String getPermitType() {
				return permitType;
			}
			public void setPermitType(String permitType) {
				this.permitType = permitType;
			}
			



}
>>>>>>> 33b67b3d4164e7ba319bd54766d6748fb733209b
