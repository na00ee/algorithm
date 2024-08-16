package algol0808;

public class Student {
	int id;
	String name;
	int grade;
	
	public Student(int id, String name, int grade) {
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", grade=" + grade + "]";
	}
	
}
