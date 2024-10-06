package pag.student.menu;

import pag.student.request.MainRequest;
import pag.student.service.IStudentService;

public class StudentMenuInterpretor {
	
	 private final IStudentService studentService;
	 
	 private final MainRequest mainRequest;
	 public StudentMenuInterpretor(IStudentService studentService , MainRequest mainRequest) {
		 this.studentService = studentService;
		this.mainRequest = mainRequest;
	 }
	 
	 public void executeOperations(String choice) {
         switch (choice) {
			case "1":
				studentService.registerStudent();
				break;
			case "2":
				studentService.findStudentById();
				break;
				
			case "3":
				studentService.getAllStudents();
				break;
				
			case "4":
				studentService.deleteStudent();
				break;
				
			case "5":
				studentService.updateStudent();
				break;
				
			case "6":
				mainRequest.menu();
				break;
				
			case "7":
             System.out.println("Exiting the program.");
				System.exit(0);
				IStudentService.SCANNER.close();
					break;
					
			default:
             System.out.println("Invalid choice! Please enter a valid option (1-5).");
				break;
			}
	 }
	
}
