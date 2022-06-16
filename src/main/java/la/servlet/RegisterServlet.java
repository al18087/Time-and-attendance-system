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
import la.dao.RegisterDAO;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		try {
			// 新規登録の入力を終えたとき
			if (action.equals("register")) {
				int loginId = Integer.parseInt(request.getParameter("login_id"));
				String password = request.getParameter("password");
				String name = request.getParameter("name");
				
				RegisterDAO dao = new RegisterDAO();
				LoginBean register = dao.saveRegister(loginId, password, name);
				
				request.setAttribute("register", register);
				Forward.gotoPage(request, response, "/registerFinish.jsp");
			}
			
			// 新規登録したあとにログインする
			else if (action.equals("login")) {
				int loginId = Integer.parseInt(request.getParameter("login_id"));
				String password = request.getParameter("password");
				String name = request.getParameter("name");
	
				LoginBean register = new LoginBean(loginId, password, name);
				
				HttpSession session = request.getSession(true);
				session.setAttribute("login", register);
				Forward.gotoPage(request, response, "/WorkServlet");
			}
			
		} catch (DAOException e) {
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
