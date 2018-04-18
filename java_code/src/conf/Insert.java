package conf;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.IndoorDAO;
import model.dto.IndoorDTO;


public class Insert extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			inserIndoor();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	private void inserIndoor() throws FileNotFoundException, IOException, SQLException {
		try (BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\user\\Desktop\\indoor.csv"))) {
			ArrayList<IndoorDTO> a = new ArrayList<>();
			for (String line = in.readLine(); line != null; line = in.readLine()) {
				String[] s = line.split(",");
				a.add(new IndoorDTO(s[0], s[1], s[2],s[3]));
			}
			IndoorDAO.insertAll(a);
			System.out.println("insert 성공");
		}
	}
}
