package la.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import la.bean.LoginBean;
import la.dao.DAOException;
import la.dao.LoginDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		
		try {
			// ログインしているか判定
			if (action.equals("isLogin")) {
				HttpSession session = request.getSession(true);
				LoginBean login = (LoginBean)session.getAttribute("login");
				
				// ログインしていない場合
				if (login == null) {
					Forward.gotoPage(request, response, "/login.jsp");
					return;
				}
				
				// ログインしているとき(セッション情報が存在しているとき)
				LoginDAO dao = new LoginDAO();
				login = dao.findLogin(login.getLoginId(), login.getPassword());
				session.setAttribute("login", login);
				Forward.gotoPage(request, response, "/WorkServlet");
			}
			
			// IDとパスワードを入力したとき
			else if (action.equals("login")) {
				int loginId = Integer.parseInt(request.getParameter("login_id"));
				String password = request.getParameter("password");
				LoginDAO dao = new LoginDAO();
				LoginBean login = dao.findLogin(loginId, password);
				
				// ログインが失敗のとき
				if (login == null) {
					request.setAttribute("message", "IDまたはパスワードが間違っています。");
					Forward.gotoPage(request, response, "/login.jsp");
					return;
				}
				
				// ログインが成功のとき
				HttpSession session = request.getSession(true);
				session.setAttribute("login", login);
				Forward.gotoPage(request, response, "/WorkServlet");
			}
			
			// ログアウト
			else if (action.equals("logout")) {
				HttpSession session = request.getSession(false);
				
				// 元々ログインしていないとき
				if (session == null) {
					request.setAttribute("message", "ログインしていません。");
					Forward.gotoPage(request, response, "/errInternal.jsp");
				}
				
				// ログインしているとき
				else {
					session.removeAttribute("calendar");
					session.removeAttribute("year_and_month");
					session.removeAttribute("yearList");
					session.removeAttribute("monthList");
					session.invalidate();
					request.setAttribute("message", "ログアウトしました。");
					Forward.gotoPage(request, response, "/login.jsp");
				}
			}
			
		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			Forward.gotoPage(request, response, "/errInternal.jsp");
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
