package la.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SelectCalendar {
	private List<Integer> yearList = new ArrayList<Integer>();
	private List<Integer> monthList = new ArrayList<Integer>();
	
	// 現在の年を取得
	int year = LocalDate.now().getYear();
	
	// 年をリストで取得
	public List<Integer> getYearList() {
		for (int y = year - 4; y <= year + 5; y++) {
			yearList.add(y);
		}
		return yearList;
	}
	
	// 月をリストで取得
	public List<Integer> getMonthList() {
		for (int month = 1; month <= 12; month++) {
			monthList.add(month);
		}
		return monthList;
	}
}
