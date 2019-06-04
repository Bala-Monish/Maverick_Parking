package Maverick_parking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.swing.JOptionPane;

import Maverick_parking.data.ReservationDAO;
import Maverick_parking.model.ModifyReservation;

/**
 * Servlet implementation class ModifyReservationController
 */
@WebServlet("/ModifyReservationController")
public class ModifyReservationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyReservationController() {
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
		HttpSession session =  request.getSession();
		ModifyReservation modifyReservation = new ModifyReservation();
		String reservationID = request.getParameter("reservationID");
		String spotID = request.getParameter("spotID");
		String startTime = request.getParameter("startTime");
		modifyReservation.setReservationID(reservationID);
		modifyReservation.setStartTime(startTime);
		session.setAttribute("modifyReservation", modifyReservation);
		if(request.getParameter("btnCancel")!=null){
			
			ReservationDAO.cancelReservation(reservationID, spotID);
			getServletContext().getRequestDispatcher("/reservationCancelled.jsp").forward(request, response);
		}
		if(request.getParameter("btnModify")!=null){
			getServletContext().getRequestDispatcher("/modifyReservation.jsp").forward(request, response);
		}
	}

}
