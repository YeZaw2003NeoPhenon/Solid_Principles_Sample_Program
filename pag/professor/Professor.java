package pag.professor;

import java.util.ArrayList;
import java.util.List;

import pag.student.Student;

public class Professor {
	private int id;
	private String name;
	private String department; 
	private List<Student> students;
	
	public Professor(int id, String name, String department) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.students = new ArrayList<>();
	}
	
	public void addStudent(Student student) {
		this.students.add(student);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
    @Override
    public String toString() {
        return "Professor{id=" + id + ", name='" + name + "', department='" + department + "'}";
    }
}
