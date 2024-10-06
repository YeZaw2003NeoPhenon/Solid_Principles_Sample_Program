package pag.student.service;

import java.util.List;

import pag.student.Student;

public interface StudentService {
	public abstract void registerStudent();
	public abstract void findStudentById();
	public abstract void getAllStudents();
	public abstract void deleteStudent();
	public abstract void updateStudent();
	
	public abstract void addMultipleStudents(List<Student> students); // external handling method
	
}
