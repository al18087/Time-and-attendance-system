package la.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import la.bean.OriginalLocalDateBean;
import la.model.SelectCalendar;
import la.model.ShowCalendar;

/**
 * Servlet implementation class WorkServlet
 */
@WebServlet("/WorkServlet")
public class WorkServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if (action == null || action.length() == 0 || action.equals("login") || 
				action.equals("isLogin")) {
			
			// 現在の月のカレンダーを取得
			ShowCalendar showCalendar = new ShowCalendar();
			// 引数の値が0のときは現在の月のカレンダー
			List<LocalDate> calendar = showCalendar.getCalendar(0);
			
			// 現在の年と月を取得
			OriginalLocalDateBean originalLocalDate = new OriginalLocalDateBean();
			originalLocalDate.setYearAndMonth(0);
			
			// 閲覧したい年と月を取得
			SelectCalendar selectCalendar = new SelectCalendar();
			List<Integer> yearList = selectCalendar.getYearList();
			List<Integer> monthList = selectCalendar.getMonthList();
			
			HttpSession session = request.getSession(true);
			session.setAttribute("calendar", calendar);
			session.setAttribute("year_and_month", originalLocalDate);
			session.setAttribute("yearList", yearList);
			session.setAttribute("monthList", monthList);
			Forward.gotoPage(request, response, "/work.jsp");
		}
		
		// work.jspから年と月を選択した場合
		else if (action.equals("search_calendar")) {
			int year = Integer.parseInt(request.getParameter("year"));
			int month = Integer.parseInt(request.getParameter("month"));
			
			// カレンダーを取得
			ShowCalendar showCalendar = new ShowCalendar(year, month);
			List<LocalDate> calendar = showCalendar.getCalendar(1);
			
			// 年と月を取得
			OriginalLocalDateBean originalLocalDateBean = new OriginalLocalDateBean(year, month);
			originalLocalDateBean.setYearAndMonth(1);
			
			// 閲覧したい年と月を取得
			SelectCalendar selectCalendar = new SelectCalendar();
			List<Integer> yearList = selectCalendar.getYearList();
			List<Integer> monthList = selectCalendar.getMonthList();
			
			HttpSession session = request.getSession(true);
			session.setAttribute("calendar", calendar);
			session.setAttribute("year_and_month", originalLocalDateBean);
			session.setAttribute("yearList", yearList);
			session.setAttribute("monthList", monthList);
			Forward.gotoPage(request, response, "/work.jsp");
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
