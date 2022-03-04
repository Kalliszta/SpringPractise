package com.qa.students.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.qa.students.domain.Student;
import com.qa.students.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	private StudentService service;

	public StudentController(StudentService service) {
		super();
		this.service = service;
	}
	
	//create - post request
	@PostMapping("/create")
	public ResponseEntity<Student> createStudent(@RequestBody Student info) {
		return new ResponseEntity<Student>(this.service.create(info), HttpStatus.CREATED);
	}
	
	//readAll - get request - list
	@GetMapping("/getAll")
	public ResponseEntity<List<Student>> getStudent(){
		return new ResponseEntity<List<Student>>(this.service.readAll(), HttpStatus.OK);
	}
	
	//readById - get request - 1 record
	@GetMapping("/get/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable Long id){
		return new ResponseEntity<Student>(this.service.readById(id), HttpStatus.OK);
	}
	
	//update - put request
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student newInfo){
		return new ResponseEntity<Student>(this.service.update(id,newInfo), HttpStatus.ACCEPTED);
	}
	
	//delete - delete request
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Boolean> removeStudent(@PathVariable Long id){
		return new ResponseEntity<Boolean>(this.service.delete(id),HttpStatus.OK);
	}
	
	//custom query
	@GetMapping("/listOfAdults")
	public ResponseEntity<List<Student>> listAdults(){
		return new ResponseEntity<List<Student>>(this.service.adults(),HttpStatus.OK);
	}
}
