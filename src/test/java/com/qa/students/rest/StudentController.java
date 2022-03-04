package com.qa.students.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.students.repo.StudentsRepo;
import com.qa.students.service.StudentsService;

@SpringBootTest
public class StudentController {
	@Autowired
	private StudentsService service;
	
	@MockBean
	private StudentsRepo repo;
	
	@Test
	public void testCreate() {
		//Students testStudent = new Student()
	}
}
