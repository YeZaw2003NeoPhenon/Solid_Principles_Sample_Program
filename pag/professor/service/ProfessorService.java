package pag.professor.service;

import java.util.Optional;

import pag.professor.Professor;

public interface ProfessorService {
	
	public abstract void createProfessor(Professor professor);
	
	public abstract void assignStudentToProfessor();
	
	public abstract void printProfessorStudentMapping();
	
	public abstract void deleteProfessorById();
	
	public abstract Optional<Professor> getProfessorById(int professorId);
	
	public abstract void removeStudentFromProfessor();
	
	public abstract void retrieveProfessorsWithMostStudents();

}
