package pag.professor.menu;

import java.util.Scanner;

public class ProfessorMenuHandler {
	
    private final Scanner scanner = new Scanner(System.in);

    public String getProfessorMenu() {
        System.out.println("\n========= Professor Management System =========");
        System.out.println("1. Register Professor");
        System.out.println("2. Assign Student to Their Professor");
        System.out.println("3. Display Professors and their Students");
        System.out.println("4. Delete Professor");
        System.out.println("5. Delete Student from Professor");
        System.out.println("6. Retrieve Professor with most student");
        System.out.println("7. Go back to main menu...");
        System.out.println("8. Exit");
        System.out.print("Select an option (1-7): ");
        return scanner.nextLine();   
    }

}
