package algol0808;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class POTest2 {

	public static void main(String[] args) {
		
		List<Student> students = new ArrayList<>();
		
		students.add(new Student(1, "홍길동", 90));
		students.add(new Student(2, "홍", 80));
		students.add(new Student(3, "길", 70));
		students.add(new Student(4, "동", 50));
		students.add(new Student(5, "길동", 50));
		
		for (Student s : students) {
			System.out.println(s);
		}
		System.out.println("----------------");
		// anonymouse nestedclass(이름없는 클래스)
//		students.sort(new Comparator<Student>() {
//			@Override
//			public int compare(Student o1, Student o2) {
//				return Double.compare(o1.grade, o2.grade);
//			}
//		});
		
		// lambda 클래스를 제거해서 메서드처럼 사용하는 함수형 방법
		// hello(){} ==> () -> {} 
		students.sort((o1, o2) -> Double.compare(o1.grade, o2.grade));
		
//		Collections.sort(students, new StudentComparator());
		for (Student s : students) {
			System.out.println(s);
		}
		
	}

}
