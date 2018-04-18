package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.plaf.synth.SynthSpinnerUI;

import model.dto.IndoorDTO;
import util.DBUtil;

public class IndoorDAO {
	static ResourceBundle sql = DBUtil.getResourceBundle();

	public static ArrayList<IndoorDTO> getAll(String curr_loc) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<IndoorDTO> comps = new ArrayList<IndoorDTO>();

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("SELECT * FROM( SELECT * FROM  indoor WHERE location=?  order by dbms_random.value) where rownum <= 10");
			pstmt.setString(1, curr_loc);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				comps.add(new IndoorDTO(rset.getString(1), rset.getString(2), rset.getString(3),rset.getString(4)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return comps;
	}

	public static void insertAll(List<IndoorDTO> indoorList) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement("INSERT INTO indoor VALUES (?, ?, ?, ?)");
			
			for (IndoorDTO info : indoorList) {
				pstmt.setString(1, info.getStore_name());
				pstmt.setString(2, info.getX());				
				pstmt.setString(3, info.getY());
				pstmt.setString(4, info.getLocation());
				pstmt.executeUpdate();
			}
			con.commit();
		} catch (SQLException e) {
			con.rollback();
			throw e;
		} finally {
			DBUtil.close(con, pstmt);
		}

	}
}