package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class GraphicController implements Controller {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currLoc = request.getParameter("currLoc");
		System.out.println("- "+currLoc+" 지역 그래픽 출력");
		long time = System.currentTimeMillis() - 3600000;
		String currTime = new SimpleDateFormat("yyyyMMddHH00").format(new Date(time));
		request.setAttribute("loc", "graphics/" + currTime + "_loc" + ".png");
		request.setAttribute("m25", "graphics/" + currTime + "_mise.png");
		request.setAttribute("c25", "graphics/" + currTime + "_chomise.png");
		request.setAttribute("map", "graphics/_allLoc.png");
		request.setAttribute("currLoc",currLoc);

		request.getRequestDispatcher("graphics.jsp").forward(request, response);
	}
	

}
