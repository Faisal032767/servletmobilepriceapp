package mypack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mydb.ConnectUtil;

@SuppressWarnings("serial")
@WebServlet("/registerServ")
public class RegisterServ extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Register Serv.........");
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		System.out.println(username);
		System.out.println(email);
		System.out.println(password);
		try {
			Connection con = ConnectUtil.getConnected();
			PreparedStatement pst = con.prepareStatement("insert into logintab values(?,?,?)");
			pst.setString(1, username);
			pst.setString(2, email);
			pst.setString(3, password);
			System.out.println("======");
			pst.executeUpdate();
			req.getRequestDispatcher("main1.html").forward(req, resp);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
