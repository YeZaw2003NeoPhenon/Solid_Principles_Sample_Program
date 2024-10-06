package pag.student.request;

import java.util.Scanner;
import pag.professor.menu.ProfessorInterpretor;
import pag.professor.menu.ProfessorMenuHandler;
import pag.professor.service.IProfessorService;
import pag.student.menu.StudentMenuHandler;
import pag.student.menu.StudentMenuInterpretor;
import pag.student.service.IStudentService;

public class MainRequest {
	 
	private static final Scanner scanner = new Scanner(System.in);
	 private final StudentMenuHandler menuHandler;
	 
	 private final StudentMenuInterpretor studentInterpretor;
	 
	private final ProfessorMenuHandler professorMenuHandler;
	
	private final ProfessorInterpretor professorInterpretor;
	
	public MainRequest() {
		this.menuHandler = new StudentMenuHandler();
		this.studentInterpretor = new StudentMenuInterpretor(new IStudentService() , this );
		this.professorMenuHandler = new ProfessorMenuHandler();
		this.professorInterpretor = new ProfessorInterpretor(new IProfessorService() , this );
		menu();
	}
	
	
	public void menu() {
        System.out.println("\n========= Main Menu =========");
        System.out.println("1. Manage Students");
        System.out.println("2. Manage Professors");
        System.out.println("3. Exit");
        System.out.print("Select an option (1-3): ");
        String choice = scanner.nextLine();
        
		while (true) {
			
			switch(choice) {
			case "1":
	            String studentChoice = menuHandler.getUserMenu();
	            studentInterpretor.executeOperations(studentChoice);
				break;
				
			case "2":
				String professorChoice = professorMenuHandler.getProfessorMenu();
				professorInterpretor.executeOperations(professorChoice);
				break;
			 case "3":
				 System.out.println("Exiting the program...");
				 System.exit(0);
				 scanner.close();
				 break;
			default:
                System.out.println("Invalid choice! Please select a valid option (1-3).");
				break;
			}
            
		}
	}
	
}
