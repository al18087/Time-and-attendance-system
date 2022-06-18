package la.model;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class ShowCalendar {
	private List<LocalDate> list = new ArrayList<LocalDate>();
	private int year;
	private int month;
	
	public ShowCalendar(int year, int month) {
		this.year = year;
		this.month = month;
	}
	
	public ShowCalendar() {}
	
	public List<LocalDate> getCalendar(int flag) {
		
		// 現在の年と月を取得
		if (flag == 0) {
			LocalDate today = LocalDate.now();
			year = today.getYear();
			month = today.getMonthValue();
		
		// work.jspから年と月を選択した場合
		} else {
			YearMonth date = YearMonth.of(year, month);
			year = date.getYear();
			month = date.getMonthValue();
		}
		
		/* 現在の年と月から日付をすべて取得 */
		// 小の月の場合
		if (isSmallMoon(month)) {
			
			// 2月の場合
			if (month == 2) {
				
				// うるう年の場合
				if (isLeapYear(year)) {
					addDate(29);
					
				// うるう年でない場合
				} else {
					addDate(28);
				}
				
			// 2月以外の場合
			} else {
				addDate(30);
			}
		
		// 大の月の場合
		} else {
			addDate(31);
		}
		
		return list;
	}
	
	// 大の月か小の月かを判定
	private boolean isSmallMoon(int month) {
		
		// 小の月の場合
		if (month == 2 || month == 4 || month == 6 || month == 9 || month == 11) {
			return true;
		}
		
		// 大の月の場合
		else {
			return false;
		}
	}
	
	// うるう年かを判定
	private boolean isLeapYear(int year) {
		
		// うるう年の場合
		if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
			return true;
			
		// うるう年でない場合
		} else {
			return false;
		}
	}
	
	// 日付をリストに格納
	private void addDate(int theEndOfTheMonth) {
		for (int day = 1; day <= theEndOfTheMonth; day++) {
			LocalDate date = LocalDate.of(year, month, day);
			list.add(date);
		}
	}
}
