package mypack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mydb.ConnectUtil;

@SuppressWarnings("serial")
public class InsertServ extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("hello from insert serv");
		String queryString = "insert into mobile values(?,?,?)";
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		int price=Integer.parseInt(req.getParameter("price"));
		
			Connection connection;
			try {
				connection = ConnectUtil.getConnected();
				PreparedStatement pst = connection.prepareStatement(queryString);
				pst.setInt(1, id );
				pst.setString(2, name);
				pst.setInt(3, price);
				pst.executeUpdate();
			    System.out.println("inserted...");
			    RequestDispatcher rs=req.getRequestDispatcher("index.html");
			    rs.forward(req, res);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

	
	}
}
