package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import model.dto.PredictedDustDTO;
import util.DBUtil;

public class PredictedDustDAO {
	static ResourceBundle sql = DBUtil.getResourceBundle();

	public static PredictedDustDTO get(String refTime, String location) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		PredictedDustDTO predictedDust = new PredictedDustDTO(refTime, location);
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("SELECT miseAfter1,  miseAfter2,  miseAfter3, chomiseAfter1, chomiseAfter2, chomiseAfter3 FROM predictedData WHERE refTime=? AND location=?");
			pstmt.setString(1, refTime);
			pstmt.setString(2, location);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				predictedDust.setMiseAfter1(rset.getInt(1));
				predictedDust.setMiseAfter2(rset.getInt(2));
				predictedDust.setMiseAfter3(rset.getInt(3));
				predictedDust.setChomiseAfter1(rset.getInt(4));
				predictedDust.setChomiseAfter2(rset.getInt(5));
				predictedDust.setChomiseAfter3(rset.getInt(6));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return predictedDust;
	}
}
