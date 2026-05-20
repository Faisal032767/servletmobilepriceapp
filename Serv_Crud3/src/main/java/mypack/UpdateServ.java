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
//@WebServlet(name = "updateServ",urlPatterns = "/updateServ")
public class UpdateServ extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("update Serv");
		int id=Integer.parseInt(req.getParameter("id").trim());
		String name=req.getParameter("name").trim();
		int price=Integer.parseInt(req.getParameter("price").trim());
//		String id1=req.getParameter("id");
		
//		id1=id1.trim();
//		
//		int id=Integer.parseInt(id1);
//		int price=Integer.parseInt(req.getParameter("price"));
//		
		System.out.println(id);
		System.out.println(name);
		System.out.println(price);
		
		// update query
		String updateQuery="update mobile set name=?,price=? where id=?";
		try {
			Connection con=ConnectUtil.getConnected();
			PreparedStatement pst=con.prepareStatement(updateQuery);
			pst.setString(1, name);
			pst.setInt(2, price);
			pst.setInt(3, id);
			
			pst.executeUpdate();
		
			
			RequestDispatcher rd=req.getRequestDispatcher("updateMsg.html");
			rd.include(req, resp);
			
//			resp.sendRedirect("insertServ");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
