import java.util.LinkedList;
import java.util.Queue;

public class Queue_큐API {

	public static void main(String[] args) {
		// Queue는 인터페이스이기 때문에 구현체를 넣어야 한다
		// LinkedList를 가장 많이 사용
		Queue<Integer> queue = new LinkedList<>();
		
		// 삽입
		queue.add(1); // 추가될 수 없으면 예외 발생
		queue.offer(1); // 추가될 수 없으면 return false
		System.out.println(queue);
		
		// 삭제
		queue.remove(); // 삭제될 수 없으면 예외 발생
		queue.poll(); // 삭제될 수 없으면 return null
		
		System.out.println(queue);
		
//		queue.remove(); // 예외 발생
		queue.poll(); // null return 후 동작 완료로 넘어감
		System.out.println("동작 완료");
		
		// 조회
		queue.element(); // 예외 발생
		queue.peek(); // return null;
	}

}
