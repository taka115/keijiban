package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.KeijibanDao;
import domain.Keijiban;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 管理者用ページに表示するコメント一覧を取得
			KeijibanDao keijibanDao = DaoFactory.createKeijibanDao();
			List<Keijiban> comments = keijibanDao.findAll();
			request.setAttribute("comments", comments);
			
			// コメント削除がリクエストされている場合
			String deleteid = request.getParameter("id");
			if (deleteid != null) {
				int id = Integer.parseInt(deleteid);
				keijibanDao.delete(id);
				comments = keijibanDao.findAll();
				request.setAttribute("comments", comments);
			}
			
			// 管理者用ページへ転送
			request.getRequestDispatcher("/WEB-INF/view/admin.jsp")
					.forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
