package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CurrentDustDAO;
import model.dao.PredictedDustDAO;
import model.dto.CurrentDustDTO;
import model.dto.PredictedDustDTO;


public class DustController implements Controller {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currLoc = request.getParameter("currLoc");
		System.out.println("- "+currLoc+" 지역 미세먼지 측정");
		
		long time = System.currentTimeMillis() - 3600000; 
		String currTime = new SimpleDateFormat("yyyy-MM-dd HH:00").format(new Date(time));

		PredictedDustDTO predDsut = null;
		CurrentDustDTO currDust = null;
		try {
			predDsut = PredictedDustDAO.get(currTime, currLoc);
			currDust = CurrentDustDAO.get(currTime, currLoc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("pmise1", criterionMP10(predDsut.getMiseAfter1()));
		request.setAttribute("pmise2", criterionMP10(predDsut.getMiseAfter2()));
		request.setAttribute("pmise3", criterionMP10(predDsut.getMiseAfter3()));
		request.setAttribute("pchoMise1", criterionMP25(predDsut.getChomiseAfter1()));
		request.setAttribute("pchoMise2", criterionMP25(predDsut.getChomiseAfter2()));
		request.setAttribute("pchoMise3", criterionMP25(predDsut.getChomiseAfter3()));
		int mise = currDust.getMise();
		int chomise = currDust.getChomise();
		String cmise = "\"" + (mise / 2 > chomise ? criterionMP10(mise): criterionMP25(chomise)) + "\""; 
		request.setAttribute("cmise", cmise);
		request.getRequestDispatcher("predTable.jsp").forward(request, response);
	}
	
	public String criterionMP10(int value) {
		if (value <=30) {
			return "Excellent";
		}else if (value <=50) {
			return "Moderate";
		}else if (value <=100) {
			return "Unhealthy";
		}else {
			return "Hazardous";
		}
	}
	
	public String criterionMP25(int value) {
		if (value <=15) {
			return "Excellent";
		}else if (value <=25) {
			return "Moderate";
		}else if (value <=50) {
			return "Unhealthy";
		}else {
			return "Hazardous";
		}
	}
}
