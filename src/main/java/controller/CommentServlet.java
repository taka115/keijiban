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
 * Servlet implementation class CmmentSrevlet
 */
@WebServlet("/comment")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			KeijibanDao keijibanDao = DaoFactory.createKeijibanDao();
			String keyword = request.getParameter("keyword");
			List<Keijiban> comments;
			
			if (keyword != null && !keyword.trim().isEmpty()) {
				// キーワードがある場合は検索
				comments = keijibanDao.findByKeyword(keyword.trim());
			} else {
				// キーワードがない場合全件取得
				comments = keijibanDao.findAll();
			}
			
			request.setAttribute("keyword", keyword); // 検索フォームに入力値を保持するため
			request.setAttribute("comments", comments);
			request.getRequestDispatcher("/WEB-INF/view/comment.jsp")
				.forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String name = request.getParameter("name");
			String comment = request.getParameter("comment");
			
			Keijiban keijiban = new Keijiban();
			keijiban.setName(name);
			keijiban.setComment(comment);
			
			KeijibanDao keijibanDao = DaoFactory.createKeijibanDao();
			keijibanDao.insert(keijiban);
			
			response.sendRedirect("/keijiban/comment");
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
