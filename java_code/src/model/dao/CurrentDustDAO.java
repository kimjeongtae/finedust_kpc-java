package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import model.dto.CurrentDustDTO;
import util.DBUtil;

public class CurrentDustDAO {
	static ResourceBundle sql = DBUtil.getResourceBundle();

	public static CurrentDustDTO get(String refTime, String location) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		CurrentDustDTO currDust = new CurrentDustDTO(refTime, location);
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(
					String.format("SELECT m.%s, c.%s FROM realtimePm10 m, realtimePm25 c WHERE m.집계시간='%s' AND c.집계시간='%s'", location, location, refTime, refTime)
					);
			//pstmt.setString(1, refTime);
			//pstmt.setString(2, refTime);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				currDust.setMise(rset.getInt(1));
				currDust.setChomise(rset.getInt(2));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return currDust;
	}
}

