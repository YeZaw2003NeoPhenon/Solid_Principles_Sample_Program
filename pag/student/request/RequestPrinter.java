package pag.student.request;

import java.util.Scanner;

public class RequestPrinter {
	public static final Scanner SCANNER = new Scanner(System.in);
	
	public static String readString(String requestMss) {
		System.out.println(requestMss);
		return SCANNER.nextLine().trim();
	}
	
	public static int readInt(String requestMss){
		while (true) {
			try {
				System.out.println(requestMss);
				return Integer.parseInt(SCANNER.nextLine().trim());
			} catch (NumberFormatException e) {
				 System.out.println("Invalid input. Please enter a valid number.");
			}	
		}
	}
	
    public static void closeScanner() {
        SCANNER.close();
    }
}
