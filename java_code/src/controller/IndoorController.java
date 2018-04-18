package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.IndoorDAO;
import model.dto.IndoorDTO;

public class IndoorController implements Controller {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currLoc = request.getParameter("currLoc");
		System.out.println("- "+currLoc+" 지역 지도 랜덤 출력");
		response.setContentType("text/plane;charset=utf-8");
		ArrayList<IndoorDTO> all_Indoor = null;
		try {
			all_Indoor=IndoorDAO.getAll(currLoc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
	    PrintWriter out = response.getWriter();
	    out.println(makeData(all_Indoor)); 
	}
	
	public String makeData(ArrayList<IndoorDTO> all_Indoor) {
		String data ="[";
		for(IndoorDTO indoor: all_Indoor) {
			data +=String.format("{title:'%s',latlng: new daum.maps.LatLng(%s,%s),},", indoor.getStore_name(), indoor.getX(), indoor.getY());
		}
		data += "]";
		return data;
	}
}
