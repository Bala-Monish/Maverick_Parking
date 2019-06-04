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

import Maverick_parking.data.SpotDetailsDAO;
import Maverick_parking.model.SpotDetails;
import Maverick_parking.model.SpotDetailsErrorMsgs;

/**
 * Servlet implementation class SpotAvailabilityController
 */
@WebServlet("/SpotAvailabilityController")
public class SpotAvailabilityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpotAvailabilityController() {
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
		
		if(request.getParameter("btnChange")!=null) {
			List<SpotDetails> spotinfo = (List<SpotDetails>)session.getAttribute("spotinfo");
			int spotid= spotinfo.get(0).getSpot_id();
			String availability = spotinfo.get(0).getIs_available();
			if(availability.equals("Y")){
				SpotDetailsDAO.updateAvailability(spotid,"N");
			}else{
				SpotDetailsDAO.updateAvailability(spotid,"Y");
			}
			List<SpotDetails> spotlist = new ArrayList<SpotDetails>();
			spotlist= SpotDetailsDAO.getSpotDetails(spotinfo.get(0));
			session.removeAttribute("spotinfo");
			session.setAttribute("spotinfo", spotlist);
			getServletContext().getRequestDispatcher("/spotSearchResults.jsp").forward(request, response);
			
			
		}
		
	}

}
