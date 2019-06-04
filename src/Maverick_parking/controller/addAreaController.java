package Maverick_parking.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Maverick_parking.data.ParkingAreaDAO;
import Maverick_parking.model.ParkingArea;
import Maverick_parking.model.ParkingAreaErrorMsgs;
import Maverick_parking.model.ReservationDetailsErrorMsgs;
import Maverick_parking.model.SpotDetails;

/**
 * Servlet implementation class addAreaController
 */
@WebServlet("/addAreaController")
public class addAreaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addAreaController() {
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
		HttpSession session =  request.getSession();
		ParkingArea parkingarea = new ParkingArea();
		List<ParkingArea> parking = new ArrayList<ParkingArea>();
		parkingarea.setFloor(request.getParameter("Floor"));
		parkingarea.setParea_name(request.getParameter("parea_name"));
		parkingarea.setPcapacity(Integer.parseInt(request.getParameter("capacity")));
		parkingarea.setPtype(request.getParameter("ptype"));
		session.setAttribute("areaDetails", parkingarea);
		ParkingAreaErrorMsgs error = new ParkingAreaErrorMsgs();
		session.setAttribute("areaerror", error);
		try{
			parkingarea.validate(parkingarea,error);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if((error.getFloorerror().equals("")) && error.getParkingareanameerror().equals("") && error.getPcapacityerror().equals("") && error.getPtypeerror().equals("")){
			
			ParkingAreaDAO.insertArea(parkingarea);
			parking = ParkingAreaDAO.getSpotDetails(parkingarea);
			session.setAttribute("parkinginfo", parking);
			getServletContext().getRequestDispatcher("/addedAreaDetails.jsp").forward(request, response);
			
		}else{
			getServletContext().getRequestDispatcher("/addNewArea.jsp").forward(request, response);
			session.removeAttribute("areaerror");
		}
	}

}
