package Maverick_parking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Maverick_parking.data.ReservationDAO;
import Maverick_parking.model.PayAndReserve;
import Maverick_parking.model.Payment;
import Maverick_parking.model.Reservation;

/**
 * Servlet implementation class PayAndReserveController
 */
@WebServlet("/PayAndReserveController")
public class PayAndReserveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayAndReserveController() {
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
		Reservation reservation = (Reservation) session.getAttribute("reservation");
		Payment payment = (Payment) session.getAttribute("payment");
		PayAndReserve pr = new PayAndReserve();
		pr.setUserName(reservation.getUserName());
		pr.setStartTime(reservation.getStartTime());
		pr.setDuration(reservation.getDuration());
		pr.setEndTime(reservation.getEndTime());
		pr.setCamera(payment.getCamera());
		pr.setCart(payment.getCart());
		pr.setHistory(payment.getHistory());
		pr.setTotalCost(payment.getTotalCost());
		pr.setParkingAreaName(reservation.getParkingAreaName());
		pr.setPermitType(reservation.getPermitType());
		try{
		ReservationDAO.reserve(pr);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		session.setAttribute("pr", pr);
		getServletContext().getRequestDispatcher("/reservationSuccess.jsp").forward(request, response);
	}
	

}
