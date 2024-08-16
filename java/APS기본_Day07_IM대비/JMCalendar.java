public class JMCalendar {
	
	public static void main(String[] args) {
		JMCalendar jmc=new JMCalendar();
		//jmc.print(2024, 8);
		jmc.print(2024);
		
	}
	public void print(int year) {
		String s=String.format("\t\t\t%d년", year);
		System.out.println(s);
		for (int i = 1; i < 13; i++) {
			print(year,i);
			System.out.println();
		}
	}
	public void print(int year, int month) {
		String s=String.format("\t\t%d년\t%d월", year,month);
		String t=String.format("일\t월\t화\t수\t목\t금\t토");
		int dayOfWeek=(sumDay(year, month, 1) -1 +1 )%7;// 요일
		System.out.println(s);
		System.out.println(t);
		for (int i = 0; i < dayOfWeek; i++) {
			System.out.print("\t");
		}
		int lastday=lastDayOfMonth(year,month);
		for (int i = 1; i <=lastday ; i++) {
			System.out.printf("%2d\t",i);
			if((i+dayOfWeek)%7==0) {
				System.out.println();
			}
		}
		
	}
	// 서기 1년 1월 1일 부터 year-1년 12월 31일까지
	public int sumDay(int year) {
		int tot=0;
		for (int i = 1; i < year; i++) {
			if(isLeapYear(year)) {
				tot+=366;
			}else {
				tot+=365;
			}
		}
		return tot;
	}
	// 2024 8 9 -> 2023 + 7월
	public int sumDay(int year, int month) {
		int tot=sumDay(year);
		for (int i = 1; i < month; i++) {
			tot+=lastDayOfMonth(year,i);
		}
		return tot;
	}
	public int sumDay(int year, int month, int day) {
		return sumDay(year,month)+day;
	}
	// CT 11  A -B +C =A and !B or C
	public boolean isLeapYear(int year) {
		return ((year%4==0) && (year%100!=0)) 
				|| (year%400==0);
	}
	// j46. fall through break만날때까지 쭉 떨어져
	public int lastDayOfMonth(int year, int month) {
		int t=0;
		if(isLeapYear(year)) {
			switch (month) {
				case 1,3,5,7,8,10,12: t=31;
					break;
				case 4,6,9,11: t=30;
					break;
				default:
					t=29;
					break;
			}
		}else {
			switch (month) {
				case 1,3,5,7,8,10,12: t=31;
					break;
				case 4,6,9,11: t=30;
					break;
				default:
					t=28;
					break;
			}
		}
		return t;
	}
	
}
