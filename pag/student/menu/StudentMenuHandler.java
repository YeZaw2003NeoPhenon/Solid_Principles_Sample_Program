package pag.student.menu;

import java.util.Scanner;

public class StudentMenuHandler {
	 private final Scanner scanner = new Scanner(System.in);
	 
	public String getUserMenu() {
        System.out.println("\n========= Student Management System =========");
        System.out.println("1. Register Student");
        System.out.println("2. Show Student by id");
        System.out.println("3. show all students");
        System.out.println("4. Delete Student by id ");
        System.out.println("5. Update Student");
        System.out.println("6. Go back to main menu");
        System.out.println("7. Exit");
        System.out.print("Select an option (1-6): ");
        return scanner.nextLine();   
	}
}
