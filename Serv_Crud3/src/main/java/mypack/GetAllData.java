package mypack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mydb.ConnectUtil;

@SuppressWarnings("serial")
public class GetAllData extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("hello from get all data");
		String countQuery = " select count(*) from mobile";
		String pageValue = req.getParameter("pageValue");
//		String endbtn=req.getParameter("end");
		String endurl = req.getParameter("end2");

		int x = 0;
		HttpSession session1 = req.getSession();
		HttpSession session2 = req.getSession();
		int end = 3;
		int y = 0;
		int y1 = 0;
		if (pageValue != null) {
			x = Integer.parseInt(pageValue);

		}
		if (endurl != null) {
			y = Integer.parseInt(endurl);
			session2.setAttribute("y", y);
			
		}
		if (session2.getAttribute("y") != null) {
			y1 = (int) session2.getAttribute("y");
			end = y1;
		}

		System.out.println("========++" + y1);

		String queryString = "select * from mobile order by id limit ?,?";
		try {
			Connection connection = ConnectUtil.getConnected();
			PreparedStatement pst = connection.prepareStatement(queryString);
			pst.setInt(1, x);
			pst.setInt(2, end);
			PreparedStatement pst1 = connection.prepareStatement(countQuery);
			ResultSet rs1 = pst1.executeQuery();
			rs1.next();
			int total = rs1.getInt(1);
			System.out.println(total);
			ResultSet rs = pst.executeQuery();

//			HttpSession session = req.getSession();
			session1.setAttribute("resultSet", rs);
			session1.setAttribute("total", total);
			session1.setAttribute("end", end);
//			session.setAttribute("end2Select", end2Select);

			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.include(req, res);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
