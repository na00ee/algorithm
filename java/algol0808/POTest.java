package algol0808;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class POTest {

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
		students.sort(new StudentComparator());
		Collections.sort(students, new StudentComparator());
		for (Student s : students) {
			System.out.println(s);
		}
		
	}

}
