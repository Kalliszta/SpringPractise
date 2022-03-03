package com.qa.students.service;

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
	
	//update - getters & setters to update each field individually + optionals
	
	
	//delete - deleteById
}
