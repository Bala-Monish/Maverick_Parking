package Maverick_parking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Maverick_parking.data.ReservationDAO;
import Maverick_parking.model.ModifyReservation;
import Maverick_parking.model.UpdateReservation;

/**
 * Servlet implementation class PayAndModifyReserveController
 */
@WebServlet("/PayAndModifyReserveController")
public class PayAndModifyReserveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayAndModifyReserveController() {
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
		UpdateReservation updateReservation = (UpdateReservation) session.getAttribute("updateReservation");
		ModifyReservation modifyReservation = (ModifyReservation) session.getAttribute("modifyReservation");
		String camera = updateReservation.getCamera();
		String cart = updateReservation.getCart();
		String history = updateReservation.getHistory();
		String totalCost = updateReservation.getTotalCost();
		String duration = updateReservation.getDuration();
		String endTime = updateReservation.getEndTime();
		String reservationID = modifyReservation.getReservationID();
		if(request.getParameter("btnPay")!=null){
			ReservationDAO.modifyReservation(reservationID, duration, endTime, camera, cart, history, totalCost);
			getServletContext().getRequestDispatcher("/modificationSuccess.jsp").forward(request, response);
		}
		
	}

}
