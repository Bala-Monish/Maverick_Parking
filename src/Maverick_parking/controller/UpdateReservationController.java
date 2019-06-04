package Maverick_parking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Maverick_parking.data.SystemUserDAO;
import Maverick_parking.model.Login;
import Maverick_parking.model.ModifyReservation;
import Maverick_parking.model.UpdateReservation;

/**
 * Servlet implementation class UpdateReservationController
 */
@WebServlet("/UpdateReservationController")
public class UpdateReservationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReservationController() {
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
		UpdateReservation updateReservation = new UpdateReservation();
		ModifyReservation modifyReservation = (ModifyReservation) session.getAttribute("modifyReservation");
		Login login = (Login) session.getAttribute("login");
		String userName = login.getUserName();
		
		updateReservation.setCamera(request.getParameter("camera"));
		updateReservation.setCart(request.getParameter("cart"));
		updateReservation.setHistory(request.getParameter("history"));
		updateReservation.setDuration(request.getParameter("duration"));
		updateReservation.setEndTime(updateReservation.getEndTime(modifyReservation.getStartTime(), updateReservation.getDuration()));
		String totalCost = updateReservation.calculateTotalCost(updateReservation.getCamera(), updateReservation.getCart(),updateReservation.getHistory());
		updateReservation.setTotalCost(totalCost);
		updateReservation.setCardNumber(SystemUserDAO.getCardNumberFromDb(userName));
		session.setAttribute("updateReservation", updateReservation);
		if(request.getParameter("btnConfirmModify")!=null){
			getServletContext().getRequestDispatcher("/payAndModifyReservation.jsp").forward(request, response);
		}
	}

}
