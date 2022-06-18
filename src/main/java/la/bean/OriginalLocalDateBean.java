package la.bean;

import java.time.LocalDate;
import java.time.YearMonth;

public class OriginalLocalDateBean {
	private int year;
	private int month;
	
	public OriginalLocalDateBean(int year, int month) {
		this.year = year;
		this.month = month;
	}
	
	public OriginalLocalDateBean() {};
	
	// 年と月を取得
	public void setYearAndMonth(int flag) {
		
		// 現在の年と月を取得
		if (flag == 0) {
			LocalDate date = LocalDate.now();
			year = date.getYear();
			month = date.getMonthValue();
		
		// work.jspで選択された年と月を取得
		} else {
			YearMonth date = YearMonth.of(year, month);
			year = date.getYear();
			month = date.getMonthValue();
		}
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getMonth() {
		return month;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
}
