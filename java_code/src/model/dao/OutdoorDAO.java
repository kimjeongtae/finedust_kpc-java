package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import model.dto.OutdoorDTO;
import util.DBUtil;

public class OutdoorDAO {
   static ResourceBundle sql = DBUtil.getResourceBundle();

   public static OutdoorDTO get(String curr_time) throws SQLException {
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      OutdoorDTO outdoor= null;
      try {
         con = DBUtil.getConnection();
         pstmt = con.prepareStatement("SELECT * FROM (SELECT title, period, f.location, homeaddress, homenumber, image1, image2, image3 FROM FestivalData f, predictedData p WHERE p.reftime= ? AND p.miseAfter1 < 50 AND f.location = p.location order by dbms_random.value) where rownum = 1");
         pstmt.setString(1, curr_time);
         rset = pstmt.executeQuery();
         if (rset.next()) {
            outdoor = new OutdoorDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), 
            		                 rset.getString(5), rset.getString(6), rset.getString(7), rset.getString(8));
         }
      } finally {
         DBUtil.close(con, pstmt, rset);
      }
      return outdoor;
   }
}