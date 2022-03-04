package com.qa.students.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.students.domain.Student;
import com.qa.students.repo.StudentsRepo;

@Service
public class StudentsService implements ServiceInterface<Student> {
	private StudentsRepo repo;

	public StudentsService(StudentsRepo repo) {
		this.repo = repo;
	}
	
	//create - logic
	public Student create(Student newStudent) {
		return this.repo.save(newStudent);
	}
	
	//read - findAll, findById
	public List<Student> readAll() {
		return this.repo.findAll();
	}
	
	public Student readById(Long id) {
		Optional<Student> op = this.repo.findById(id);
		return op.get();
	}
	
	//update - getters & setters to update each field individually + optional
	public Student update(Long id, Student newVersion) {
		Optional<Student> op = this.repo.findById(id);
		if (op.isPresent()) {
			Student existingStudent = op.get();
			existingStudent.updateFields(newVersion);
			return this.repo.save(existingStudent);
		}
		return null;
	}
	
	//delete - deleteById
	public boolean delete(Long id) {
		try {
			this.repo.deleteById(id);
		} catch (Exception e) { //make more specific
			return false;
		}
		return !(this.repo.existsById(id)); //true if yes so flip to make true if delete successful
	}
	
	//returns list of adults
	public List<Student> adults(){
		return this.repo.getAdult();
	}
}
