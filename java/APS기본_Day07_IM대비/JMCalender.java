
public class JMCalender {

	public static void main(String[] args) {
		
	}
	
	// 서기 1년 1월 1일부터 year-1년 12월 31일까지
	public int sumDay(int year, int month) {
		int tot = 0;
		for (int i = 1; i < year; i++) {
			if (isLeapYear(year)) {
				tot+=366;
			} else {
				tot+=365;
			}
		}
		return tot;
	}
	
	public boolean isLeapYear(int year) {
		return ((year%4==0) && (year%100!=0)) || (year%400==0);
	}
	
	// fall through break 만날 때까지 쭉 떨어져
	public int dayOfMonth(int year, int month) {
		int t = 0;
		if(isLeapYear(year)) {
			switch (month) {
				case 1, 3, 5, 7, 8, 10, 12: 
					t = 31;
					break;
				case 4, 6 ,9, 11: 
					t = 30;
					break;
				default:
					t = 29;
					break;
			}
		} else {
			switch (month) {
				case 1, 3, 5, 7, 8, 10, 12: 
					t = 31;
					break;
				case 4, 6 ,9, 11: 
					t = 30;
					break;
				default:
					t = 28;
					break;
			}
		}
		return t;
	}
}
