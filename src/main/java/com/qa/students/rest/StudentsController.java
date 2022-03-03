package com.qa.students.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.qa.students.domain.Students;
import com.qa.students.service.StudentsService;

@RestController
@RequestMapping("/student")
public class StudentsController {

	private StudentsService service;

	public StudentsController(StudentsService service) {
		super();
		this.service = service;
	}
	
	//create - post request
	@PostMapping("/create")
	public ResponseEntity<Students> createStudent(@RequestBody Students info) {
		return new ResponseEntity<Students>(this.service.create(info), HttpStatus.CREATED);
	}
	
	//readAll - get request - list
	@GetMapping("/getAll")
	public ResponseEntity<List<Students>> getStudent(){
		return new ResponseEntity<List<Students>>(this.service.readAll(), HttpStatus.OK);
	}
	
	//readById - get request - 1 record
	@GetMapping("/get/{id}")
	public ResponseEntity<Students> getStudent(@PathVariable Long id){
		return new ResponseEntity<Students>(this.service.readById(id), HttpStatus.OK);
	}
	
	//update - put request
	@PutMapping("/update/{id}")
	public ResponseEntity<Students> updateStudent(@PathVariable Long id, @RequestBody Students newInfo){
		return new ResponseEntity<Students>(this.service.update(id,newInfo), HttpStatus.ACCEPTED);
	}
	
	//delete - delete request
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Boolean> removeStudent(@PathVariable Long id){
		return new ResponseEntity<Boolean>(this.service.delete(id),HttpStatus.OK);
	}
	
	//custom query
	@GetMapping("/listOfAdults")
	public ResponseEntity<List<Students>> listAdults(){
		return new ResponseEntity<List<Students>>(this.service.adults(),HttpStatus.OK);
	}
}
