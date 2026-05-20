package mypack;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mydb.ConnectUtil;

public class DeleteServ extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
		System.out.println("Delete Serv11");
		String delString="delete from mobile where id=?";
		Connection connection=null;
		int deleteId=Integer.parseInt(req.getParameter("deleteRecord"));
		System.out.println(deleteId);
			try {
				connection=ConnectUtil.getConnected();
				PreparedStatement pst=connection.prepareStatement(delString);
				pst.setInt(1, deleteId);
				pst.executeUpdate();
				res.sendRedirect("insertServ");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      
		
	}

}
