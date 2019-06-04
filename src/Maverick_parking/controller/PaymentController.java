package Maverick_parking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Maverick_parking.data.SystemUserDAO;
import Maverick_parking.model.CreateUserProfile;
import Maverick_parking.model.Payment;
import Maverick_parking.model.Reservation;
import Maverick_parking.model.ReservationErrorMsgs;
import Maverick_parking.model.UpdateProfile;

/**
 * Servlet implementation class PaymentController
 */
@WebServlet("/PaymentController")
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentController() {
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
		Payment payment = new Payment();
		ReservationErrorMsgs resersvationErrorMsgs = new ReservationErrorMsgs();
		Reservation reservation = (Reservation) session.getAttribute("reservation");
		if(request.getParameter("btnPay")!=null){
		payment.setCamera(request.getParameter("camera"));
		payment.setCart(request.getParameter("cart"));
		payment.setHistory(request.getParameter("history"));
		boolean cartChk = payment.validateCartTimings(reservation.getStartTime());

		if(!cartChk){
			payment.setCart("32.00");
		}
		payment.setTotalCost(payment.calculateTotalCost(payment.getCamera(), payment.getCart(),payment.getHistory()));
		payment.setCardNumber(SystemUserDAO.getCardNumberFromDb(reservation.getUserName()));
		String permitType = SystemUserDAO.getPermitType(reservation.getUserName());
		if(permitType == null){
			permitType = "";
		}
		
		payment.validateAccessTypeForUser(permitType,reservation.getPermitType(),resersvationErrorMsgs);
//		payment.validateReservationTimeWindowForUser(reservation.getStartTime(), reservation.getUserName(), resersvationErrorMsgs);
		payment.validateUserAccountStatus(reservation.getUserName(), resersvationErrorMsgs);
		
		session.setAttribute("payment", payment);
		session.setAttribute("resersvationErrorMsgs", resersvationErrorMsgs);
		if(resersvationErrorMsgs.getErrorMsg().equals("")&&resersvationErrorMsgs.getTimeWindowErrorMsg().equals("")&&resersvationErrorMsgs.getUserRevokedErrorMsg().equals("")&&resersvationErrorMsgs.getCartErrorMsg().equals("")){
		session.removeAttribute("reservationErrorMsgs");	
		getServletContext().getRequestDispatcher("/payment.jsp").forward(request, response);
		}
		else{
			
			getServletContext().getRequestDispatcher("/selectedParkingSpot.jsp").forward(request, response);
			session.removeAttribute("reservationErrorMsgs");
		}
		
		}
	}

}
