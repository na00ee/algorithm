package algol0808;

public class Teacher implements Comparable<Teacher> {
	int id;
	String name;
	int career;
	
	public Teacher(int id, String name, int career) {
		super();
		this.id = id;
		this.name = name;
		this.career = career;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", career=" + career + "]";
	}

	@Override
	public int compareTo(Teacher o) {
		return this.career - o.career;
	}
	
}
