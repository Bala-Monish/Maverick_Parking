package Maverick_parking.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Maverick_parking.data.ReservationDetailsDAO;
import Maverick_parking.model.ReservationDetails;
import Maverick_parking.model.ReservationDetailsErrorMsgs;
import Maverick_parking.model.SpotDetails;

/**
 * Servlet implementation class ReservationDetailsController
 */
@WebServlet("/ReservationDetailsController")
public class ReservationDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationDetailsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session =  request.getSession();
		ReservationDetails reservationDetails = new ReservationDetails();
		List<ReservationDetails> reservationinfo = new ArrayList<ReservationDetails>();
		if(request.getParameter("btnSearch")!=null) {
			String reservation_ID = request.getParameter("reservationID");
			String starttime = request.getParameter("starttime");
			String duration = request.getParameter("duration");
			
			int reservation = Integer.parseInt(reservation_ID);
			reservationDetails.setReservation_id(reservation);
			reservationDetails.setStart_time(starttime);
			reservationDetails.setDuration(duration);
			
			session.setAttribute("reservationDetails", reservationDetails);
			ReservationDetailsErrorMsgs error = new ReservationDetailsErrorMsgs();
			session.setAttribute("reservationIDerror", error);
			try{
				reservationDetails.validate(reservationDetails,error);
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			if(error.getReservationDetailerror().equals("") && (error.getReservationDurationerror().equals("")) && (error.getReservationStarttimeerror().equals(""))){
				ReservationDetailsDAO.updateReservation(reservationDetails);
				reservationinfo = ReservationDetailsDAO.getReservationDetails(reservationDetails);
				session.setAttribute("reservationinfo", reservationinfo);
				getServletContext().getRequestDispatcher("/reservationUpdateResults.jsp").forward(request, response);
			}else{
				getServletContext().getRequestDispatcher("/modifyReservation.jsp").forward(request, response);
				session.removeAttribute("reservationIDerror");
			}
			
		}
		
	}

}
