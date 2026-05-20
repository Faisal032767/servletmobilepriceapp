package mypack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mydb.ConnectUtil;

@SuppressWarnings("serial")
public class AddServ extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Addserv");
		int id = Integer.parseInt(req.getParameter("id"));
		int price = Integer.parseInt(req.getParameter("price"));
		String name = req.getParameter("name");

		System.out.println(id);
		System.out.println(price);
		System.out.println(name);
		String insertQuery = "insert into mobile values(?,?,?)";
		try {
			Connection con = ConnectUtil.getConnected();
			PreparedStatement pst = con.prepareStatement(insertQuery);
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setInt(3, price);
			pst.executeUpdate();

			System.out.println("Record Inserted...");
//			RequestDispatcher rd = req.getRequestDispatcher("/insertServ");
//			rd.forward(req, resp);
			resp.sendRedirect("insertServ");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
