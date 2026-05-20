package mypack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class LoginServ extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
//	PrintWriter pw=resp.getWriter();
//	pw.print("<html> <body bgColor='red'> <a href='insertServ'> InserServ</a> </body></html>");
    req.getRequestDispatcher("insertServ").forward(req, resp);
}
}
