package pag.professor.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import pag.professor.Professor;
import pag.student.Student;
import pag.student.request.RequestPrinter;

public class IProfessorService implements ProfessorService {
	
    private final Map<Integer, Professor> professorMap;
    
    public IProfessorService() {
    	this.professorMap = new HashMap<>();
    }
    
	@Override
	public void createProfessor(Professor professor) {
         
		if(professorMap.containsKey(professor.getId())) {
			 System.out.println("Professor: you are trying to merge into is already exist!");
			return;
		}
		
		professorMap.put(professor.getId(), professor);
		System.out.println("Added professor: " + professor.getName());
   
	}

	public void savedProfessor() {
		
	      int id =  RequestPrinter.readInt("Enter professor ID: ");
	      
	      String name = RequestPrinter.readString("Enter professor name: ");
	      
	      String department = RequestPrinter.readString("Enter professor department: ");
	      
	      Professor professor = new Professor(id, name, department);

	      createProfessor(professor);
	}



	public void setAsideProfessorAndStudentDatas(int professorId, Student student) {
		
		Optional<Professor> currProfessorOp = Optional.of(professorMap.get(professorId));
		
		if(currProfessorOp.isPresent()) {
		Professor professor = currProfessorOp.get();
			professor.addStudent(student);
            System.out.println("Assigned student " + student.getName() + " to Professor " + professor.getName());
		}
		else {
            System.out.println("No professor found with ID: " + professorId);
		}
	}
	
	@Override
	public void assignStudentToProfessor() {
		
		int professorId = RequestPrinter.readInt("Enter professor ID to assign student:");
		
		
		int studentId = RequestPrinter.readInt("Enter student ID: ");
		
		String studentName = RequestPrinter.readString("Enter student name:");
		
		String studentEmail = RequestPrinter.readString("Enter student email:");
		
		String studentMajor = RequestPrinter.readString("Enter student major:");
		
        Student student = new Student(studentId, studentName, studentEmail, studentMajor);
        
        setAsideProfessorAndStudentDatas(professorId , student);
	}

	@Override
	public void printProfessorStudentMapping() {
		
//		List<Professor> professors =  (List<Professor>) professorMap.values();
//		for(Professor professor : professorMap.values()) {
//			professors.getStudents()
//		}
		
		if(professorMap.values().isEmpty()) {
			System.out.println("Professors Data Base is insurmontably empty!");
		}
		
		for( Integer professorId : professorMap.keySet()) {
			Professor professor =professorMap.get(professorId);
			   System.out.println(professor);
			for(Student student : professor.getStudents()) {
				System.out.println("    " + student);
			}
		}
	}

	@Override
	public void deleteProfessorById() {
		
		int professorId = RequestPrinter.readInt("Enter Professor Id to delete!");
		
		if(!professorMap.containsKey(professorId)) {
			System.out.println("No professor found with ID: " + professorId);
		}
		else if(professorMap.isEmpty()) {
			System.out.println("There is no professorData To rip off!");
		}
		
		if( professorMap.remove(professorId, professorMap.get(professorId))) {
			System.out.println("Professor data is deleted Gratifyingly");
		}
	}

	@Override
	public Optional<Professor> getProfessorById(int professorId) {
		
	    if (!professorMap.containsKey(professorId)) {
	        System.out.println("No professor found with ID: " + professorId);
	        return Optional.empty();  
	    }

	    return Optional.of(professorMap.get(professorId));
	}

	@Override
	public void removeStudentFromProfessor() {
		
		int professorId = RequestPrinter.readInt("Enter The Professor Id");
		Optional<Professor> professorOp =  getProfessorById(professorId);
		
		int studentId = RequestPrinter.readInt("Enter The Student Id");
		
		if(professorOp.isPresent()) {
			Professor professor = professorOp.get();
	        if (professor.getStudents().isEmpty()) {
	            System.out.println("Professor " + professor.getName() + " has no students assigned.");
	            return;
	        }
	        
	        Optional<Student> processedStudent = professor.getStudents()
	        							 .stream()
	        							 .filter(student -> student.getId() == studentId)
	        							 .findFirst();
	        
	        if(processedStudent.isPresent()) {
	        	professor.getStudents().remove(processedStudent.get());
	            System.out.println("Removed student: " + processedStudent.get().getName() + " from Professor: " + professor.getName());
	        }
	        else {
	            System.out.println("No student found with ID: " + studentId + " for Professor: " + professor.getName());	
	        }   
		}
		else {
			 System.out.println("No professor found with ID: " + professorId);
		}
	}

	@Override
	public void retrieveProfessorsWithMostStudents() {
		Professor maxProfessor = null;
		int max_count = 0;
		List<Professor> professors = new ArrayList<>(professorMap.values());
		
		for (Professor professor : professors ) {
			
			if(professor.getStudents().size() > max_count) {
				max_count = professor.getStudents().size();
				maxProfessor = professor;
				continue;
			}
			else {
				break;
			}
			
		}
		
		if( maxProfessor != null ) {
	        System.out.println("Professor with the most students: " + maxProfessor.getName() + " with " + max_count + " students.");
		}
		else {
			 System.out.println("No professors found.");
		}
		
	}
	
}
