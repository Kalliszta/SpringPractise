package com.qa.students.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.students.domain.Students;
import com.qa.students.repo.StudentsRepo;

@Service
public class StudentsService {
	private StudentsRepo repo;

	public StudentsService(StudentsRepo repo) {
		super();
		this.repo = repo;
	}
	
	//create - logic
	public Students create(Students newStudent) {
		return this.repo.save(newStudent);
	}
	
	//read - findAll, findById
	public List<Students> readAll() {
		return this.repo.findAll();
	}
	
	public Students readById(Long id) {
		Optional<Students> op = this.repo.findById(id);
		return op.get();
	}
	
	//update - getters & setters to update each field individually + optionals
	public Students update(Long id, Students newVersion) {
		Optional<Students> op = this.repo.findById(id);
		if (op.isPresent()) {
			Students existingStudent = op.get();
			existingStudent.setName(newVersion.getName());
			existingStudent.setAge(newVersion.getAge());
			return this.repo.save(existingStudent);
		}
		return null;
	}
	
	//delete - deleteById
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return !(this.repo.existsById(id)); //true if yes so flip to make true if delete successful
	}
	
	//returns list of adults
	public List<Students> adults(){
		return this.repo.getAdult();
	}
}
