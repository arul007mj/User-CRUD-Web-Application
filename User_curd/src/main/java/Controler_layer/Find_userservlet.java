package Controler_layer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model_layer.User;
import Model_layer.UserDao;

@WebServlet("/find")
public class Find_userservlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=resp.getWriter();
		HttpSession session=req.getSession(false);
		String u_input=req.getParameter("find");
		System.out.println(u_input);
		if (session != null ) {
			UserDao dao=new UserDao();
			ArrayList< User> list=new ArrayList<User>();
			try {
				list=dao.find(u_input);
				if (!list.isEmpty()) {
					req.setAttribute("list", list);
					RequestDispatcher Dispatcher=req.getRequestDispatcher("Fetchall.jsp");
					Dispatcher.forward(req, resp);
				}else {
					out.print("<h1> !!! THERE IS NO NAME OR EMAIL LIKE THAT  .......  <br> ......RETRY AGAIN......() () ()</h1>");
					RequestDispatcher Dispatcher=req.getRequestDispatcher("Fetchall.jsp");
					Dispatcher.include(req, resp);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.print("<h1>"+e+"<h1>");
			}
		}else {
			out.print("<h1> !!! LOGIN FIRST .......</h1>");
			RequestDispatcher Dispatcher=req.getRequestDispatcher("Login.jsp");
			Dispatcher.include(req, resp);
		}
  }
}
