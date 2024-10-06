package pag.student.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

import pag.student.Student;
import pag.student.request.RequestPrinter;

public class IStudentService implements StudentService{
	
	public final Map<Integer, Student> studentMap = new HashMap<>();
	public static final Scanner SCANNER = new Scanner(System.in);
	
	private int studentCount = 1;
	
	// User interactions + Business Logics -> egraciously break off SRP
	
	@Override
	public void registerStudent() {
     	String name	= RequestPrinter.readString("Enter student name");
		
	   	String email = RequestPrinter.readString("Enter student email or (Press 'Enter' if no email)");	
	
		Optional<String> OpEmail = email.isEmpty() ? Optional.empty() : Optional.of(email);
		
		String major = RequestPrinter.readString("Enter student major");
		
		Student student = new Student(studentCount++ , name, OpEmail.orElse("No Email"), major);
		
		createStudent(student);
	}
	
	private void createStudent(Student student) {
		
		if(studentMap.containsKey(student.getId())){
			System.out.println("Student with endovoured id already exists!");
			return;
		}	
		
		studentMap.put(student.getId() , student);
		
        System.out.println("Student '" + student.getName() + "' registered successfully with ID: " + student.getId());

	}


	public void findStudentById() {
        if (studentMap.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        
        
        int id = RequestPrinter.readInt("Enter the student ID to search: ");
        
        boolean found = false;
        
        for( int studentId : studentMap.keySet()) {
        	if( studentId == id ) {
            	Student currStudent = studentMap.get(studentId);
                System.out.println("Student found: Name = " + currStudent.getName() + ", ID = " + currStudent.getId());
                found = true;
                break;
        	}
        }
        if (!found) {
            System.out.println("No student found with ID: " + id);
        }
	}

	@Override
	public void getAllStudents() {
		
		 System.out.println("\n========== Student List ==========");
		 
		 if( studentMap.isEmpty()) {
	            System.out.println("No students registered.");
	            return;
		 }
		 else {
			for( Map.Entry<Integer, Student> entry : studentMap.entrySet()) {
               System.out.println("Name: " + entry.getKey() + ", ID: " + entry.getValue());
			}
		 }
	     System.out.println("==================================");
	}



	@Override
	public void updateStudent() {
		  System.out.print("Enter the student ID : ");
	      int id = Integer.parseInt(SCANNER.nextLine().trim());
	      
	      Optional<Student> studentToUpdate =  getStudentToUpdate(id);
	      
	      if(studentToUpdate.isPresent()) {
	    	 Student student = studentToUpdate.get();
	    	 System.out.println("Student found: " + student);
	    	 updateStudentField(student);
	      }
	      else {
	    	  System.out.println("No student found with the given ID.");
	      }
	}
	
	public void updateStudentField(Student student) {
        System.out.println("Which field do you want to update?");
        System.out.println("1. Name");
        System.out.println("2. Email");
        System.out.println("3. Major");
        System.out.print("Enter your choice (1-3): ");
        
        String choice = SCANNER.nextLine();
       
      switch (choice) {
		case "1":
			String newName = RequestPrinter.readString("Enter new name to update?");
			updateStudentName(student , newName);
			break;
			
       case "2":
       	String newEmail = RequestPrinter.readString("Enter new email:");
       	updateStudentEmail( student , newEmail);
           break;
           
       case "3":
       	String newMajor = RequestPrinter.readString("Enter new major:");
     
           updateStudentMajor(student , newMajor);
           break;

		default:
			System.out.println("Invalid choice! No updates made.");
			break;
		}
		
	}

	private void updateStudentName(Student student, String name) {
		student.setName(name);
		 System.out.println("Student name updated Triumphantly.");
	}
	
	private void updateStudentEmail(Student student, String newEmail) {
	    student.setEmail(newEmail);
	    System.out.println("Student email updated Salubriously.");
	}

	private void updateStudentMajor(Student student, String newMajor) {
	    student.setMajor(newMajor);
	    System.out.println("Student major updated Untarnishedly.");
	}

	private Optional<Student> getStudentToUpdate(int id) {
       
		return Optional.ofNullable(studentMap.get(id));
	}

	@Override
	public void deleteStudent() {
		
		   if (studentMap.isEmpty()) {
		        System.out.println("No students available to delete.");
		        return;
		    }
		   
		    int id = RequestPrinter.readInt("Enter the student ID to delete: ");
		    
		    if(studentMap.remove(id, studentMap.get(id))) {
		        System.out.println("Student with ID " + id + " has been deleted.");
		    }
		    else {
		    	System.out.println("No student found with ID: " + id);
		    }
		    
		}
	
	@Override
	public void addMultipleStudents(List<Student> students) {
		
		if(students.isEmpty() || students == null ) {
            System.out.println("No students to add.");
			 return;
		}
		
		for( Student student : students ) {
			
			if(isValidStudent(student)) {
				
				if(!studentMap.containsKey(student.getId())) {
					studentMap.put(student.getId(), student);
					 System.out.println("Added student: " + student.getName());
				}
				else {
                    System.out.println("Duplicate student found with ID: " + student.getId() + ". Skipping...");
				}
			}
			else {
                System.out.println("Invalid student: " + student.getName() + ". Skipping...");
			}
		}
		  System.out.println("All students processed.");
	}
	
	public boolean isValidStudent(Student student) {
		if(student.getName() == null || student == null || student.getMajor() == null || student.getEmail() == null || student.getId() <= 0 ) {
			return false;
		}
		
		return true;
	}
	
}