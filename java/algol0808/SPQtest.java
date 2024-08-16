package algol0808;

import java.util.PriorityQueue;

public class SPQtest {

	public static void main(String[] args) {
		PriorityQueue<Student> pqs = new PriorityQueue<>(new StudentComparator());
		pqs.offer(new Student(1, "홍", 90));
		pqs.offer(new Student(2, "김", 70));
		pqs.offer(new Student(3, "나", 50));
		pqs.offer(new Student(4, "박", 80));
		pqs.offer(new Student(5, "이", 90));
		while(!pqs.isEmpty()) {
			Student t = pqs.poll();
			System.out.println(t);
		}
	}

}
