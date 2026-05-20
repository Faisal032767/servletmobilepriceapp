package mypack_filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import mydb.ConnectUtil;

public class LoginServFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("before filter");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
//		System.out.println(email);
//		System.out.println(password);
//		String emaildb = null;
		String passworddb = null;
		try {
			Connection con = ConnectUtil.getConnected();
			PreparedStatement pst1 = con.prepareStatement("select email from logintab");
			ResultSet rs1 = pst1.executeQuery();

			boolean emailPresentInDB = false;
			while (rs1.next()) {
				if (email.equals(rs1.getString(1))) {
					emailPresentInDB = true;
					break;
				}

			}

//			System.out.println("eeeeeeeeeeeeeeeeeeeeeeeee        " + emailPresentInDB);
			if (emailPresentInDB == false) {
				request.getRequestDispatcher("login.html").forward(request, response);
				response.setContentType("text/html");
				PrintWriter pw = response.getWriter();
				pw.print("<script> alert('Incorrect Email-Id') </script>");
				System.out.println("email");
				pw.print("<script>window.location.href='login.html'</script>");
			} else {
				PreparedStatement pst = con.prepareStatement("select password from logintab where email=?");

				pst.setString(1, email);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					passworddb = rs.getString(1);
				}
				System.out.println("===========");
//				System.out.println(emaildb);
				System.out.println(passworddb);
				if (!password.equals(passworddb)) {
					response.setContentType("text/html");
					PrintWriter pw = response.getWriter();
					request.getRequestDispatcher("login.html").forward(request, response);
					pw.println("<html> <body>");
					pw.println("<script> alert('Incorrect Password') </script>");
					System.out.println("pass");
					pw.println("<script>window.locatiologin.html'</script>");
					pw.println(" </body> </html>");
				
				}
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		chain.doFilter(request, response);

	}

}
