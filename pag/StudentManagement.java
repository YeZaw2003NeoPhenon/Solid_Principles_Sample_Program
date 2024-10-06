package pag;

import java.util.Arrays;
import java.util.List;

import pag.student.Student;
import pag.student.request.MainRequest;
import pag.student.service.IStudentService;

public class  StudentManagement{
	
	 public StudentManagement() {
		new MainRequest();
	}
		
	public static void main(String[] args) {
		  IStudentService studentService = new IStudentService();
		  
		List<Student> students =  Arrays.asList(
				  new Student(1,"Alice","alice@gmail.com","Software Engineering"),
				  new Student(2, "Bob", "bob@example.com", "Mathematics"),
				  new Student(3, "Courney", "courney@example.com", "Social Science"),
				  new Student(4, "Neli", "neli@.com", "Data Science")
				  );
		
		studentService.addMultipleStudents(students);
		
		new StudentManagement();
	}
}
