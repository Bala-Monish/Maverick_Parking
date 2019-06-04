package Maverick_parking.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Maverick_parking.model.Login;
import Maverick_parking.model.Reservation;
import Maverick_parking.model.UserSearch;
import Maverick_parking.model.UserSearchResults;

/**
 * Servlet implementation class SelectedParkingController
 */
@WebServlet("/ReservationController")
public class ReservationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Login login = (Login) session.getAttribute("login");
		UserSearch userSearch = (UserSearch) session.getAttribute("user_search");
		Reservation reservation = new Reservation();
		reservation.setUserName(login.getUserName());
		reservation.setStartTime(userSearch.getStartTime(userSearch.getStHr(), userSearch.getStMin()));
		reservation.setDuration(userSearch.getDuration());
		reservation.setEndTime(reservation.getEndTime(reservation.getStartTime(), reservation.getDuration()));
	    if(request.getParameter("btnSelect")!=null){
	    	reservation.setParkingAreaName(request.getParameter("parkingAreaName"));
	    	reservation.setPermitType(request.getParameter("permitType"));
	    	reservation.setAvailableSpots(request.getParameter("availableSpots"));
	    	reservation.setFloor(request.getParameter("floor"));
	    }
		session.setAttribute("reservation", reservation);
		getServletContext().getRequestDispatcher("/selectedParkingSpot.jsp").forward(request, response);
		
		
	}

}
