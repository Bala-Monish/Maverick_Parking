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

/**
 * Servlet implementation class ReservationDeleteContoller
 */
@WebServlet("/ReservationDeleteController")
public class ReservationDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationDeleteController() {
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
			int reservation = Integer.parseInt(reservation_ID);
			reservationDetails.setReservation_id(reservation);
			session.setAttribute("reservationDelete", reservationDetails);
			ReservationDetailsErrorMsgs error = new ReservationDetailsErrorMsgs();
			session.setAttribute("reservationIDerror", error);
			try{
				reservationDetails.validate(reservationDetails,error);
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			if(error.getReservationDetailerror().equals("")){
				ReservationDetailsDAO.deleteReservation(reservationDetails);
				getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
			}else{
				getServletContext().getRequestDispatcher("/deleteReservation.jsp").forward(request, response);
				session.removeAttribute("reservationIDerror");
			}
			
			
		}
	}

}
