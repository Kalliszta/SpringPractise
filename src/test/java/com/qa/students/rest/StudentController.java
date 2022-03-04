package com.qa.students.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.students.domain.Student;
import com.qa.students.repo.StudentsRepo;
import com.qa.students.service.StudentsService;

@SpringBootTest
public class StudentController {
	@MockBean
	private StudentsService service;
	
	@Autowired
	private StudentsController controller;
	
//	@Test
//	public void testCreate() {
//		Student testStudent = new Student(1L, "Lily", 15,"na");
//		when(service.create(testStudent)).thenReturn(testStudent);
//		assertThat(testStudent).isEqualTo(controller.createStudent(testStudent));
//		verify(service, times(1)).create(testStudent);
//		
//	}
}
