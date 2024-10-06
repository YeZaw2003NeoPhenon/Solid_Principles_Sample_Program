package pag.professor.menu;

import pag.professor.service.IProfessorService;
import pag.student.request.MainRequest;

public class ProfessorInterpretor {

	private final IProfessorService professorService;
	
	private final MainRequest mainRequest;
	public ProfessorInterpretor(IProfessorService professorService , MainRequest mainRequest){
		this.professorService = professorService;
		this.mainRequest = mainRequest;
	}
	
	public void executeOperations(String choice) {
		switch (choice) {
		case "1":
			  professorService.savedProfessor();
			break;
		case "2":
			  professorService.assignStudentToProfessor();
			break;
		case "3":
			  professorService.printProfessorStudentMapping();
			break;
		case "4":
			  professorService.deleteProfessorById();
			break;
		case "5":
			professorService.removeStudentFromProfessor();
			break;
		case "6":
			mainRequest.menu();
			break;
		case "7":
		       System.out.println("Exiting the program.");
               System.exit(0);
               break;
		default:
            System.out.println("Invalid choice! Please enter a valid option (1-3).");
			break;
		}
	}
}
