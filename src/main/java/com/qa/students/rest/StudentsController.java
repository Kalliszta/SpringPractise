package com.qa.students.rest;

import org.springframework.web.bind.annotation.*;

import com.qa.students.domain.Students;
import com.qa.students.service.StudentsService;

@RestController
public class StudentsController {

	private StudentsService service;

	public StudentsController(StudentsService service) {
		super();
		this.service = service;
	}
	
	//create - post request
	@PostMapping("/create")
	public Students createMap(@RequestBody Students info) {
		return this.service.create(info);
	}
	
	//readAll - get request - list
	//readById - get request - 1 record
	
	//update - put request
	
}
