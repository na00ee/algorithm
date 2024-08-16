package algol0808;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return Double.compare(o1.grade, o2.grade);
	}
	
//	@Override
//	public int compare(Student o1, Student o2) {
//		int r = Double.compare(o1.grade, o2.grade); // 
//		if(r==0) {
//			return o1.name.compareTo(o2.name);
//		}
//		return -Double.compare(o1.grade, o2.grade); // int의 전 범위로 grade를 받는 경우엔 compare보다 빼서 비교하는 게 낫다.
//	}

}
