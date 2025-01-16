package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import dao.DaoFactory;
import domain.Admin;

/**
 * Servlet implementation class LoginSrevlet
 */
@WebServlet("/login")
public class LoginSrevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/login.jsp")
				.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		  String loginId = request.getParameter("loginId");
		  String loginPass = request.getParameter("loginPass");
		  AdminDao adminDao = DaoFactory.createAdminDao();
		  Admin admin = 
				adminDao.findByLoginIdAndLoginPass(loginId, loginPass);
		  if (admin != null) {
			  request.getSession().setAttribute("loginId",
					  admin.getLoginId());
			  System.out.println("");
			  response.sendRedirect("comment");
		  } else {
			  request.setAttribute("error", true);
			  request.getRequestDispatcher("login.jsp")
					.forward(request, response);
		  }
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
