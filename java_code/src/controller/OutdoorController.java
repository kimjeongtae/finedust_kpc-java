package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.OutdoorDAO;
import model.dto.OutdoorDTO;

public class OutdoorController implements Controller {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/plane;charset=utf-8");
      System.out.println("- 실외지역 랜덤 출력");
      
      long time = System.currentTimeMillis() - 3600000;
      String currTime = new SimpleDateFormat("yyyy-MM-dd HH:00").format(new Date(time));
      OutdoorDTO outdoor = null;
      try {
       outdoor = OutdoorDAO.get(currTime);
      } catch (SQLException e) {
         e.printStackTrace();
      }
      if (outdoor == null) {
         response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println("<h2 align=\"center\">미세먼지 초심각! </h2><br>");
            out.println("<img src=\"images/maxmise.PNG\" style=\"width:100%;\"/>");
            out.println("<a href=\"#Indoor\" align=\"right\"><h6 align=\"right\">실내 장소로 가기</h6><br>");
      }else {
         request.setAttribute("festival_name", outdoor.getFestival_name());
         request.setAttribute("period", outdoor.getPeriod());
         request.setAttribute("loc", outdoor.getLoc());
         request.setAttribute("home", outdoor.getHome());
         request.setAttribute("num", outdoor.getInform());
         request.setAttribute("img1", outdoor.getI1());
         request.setAttribute("img2", outdoor.getI2());
         request.setAttribute("img3", outdoor.getI3());
         request.getRequestDispatcher("outdoor.jsp").forward(request, response);
      }
   }
}