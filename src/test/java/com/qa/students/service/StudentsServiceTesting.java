package com.qa.students.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.students.domain.Student;
import com.qa.students.repo.StudentsRepo;

@SpringBootTest
public class StudentsServiceTesting {
	
	private Student newStudent;
	private Student savedStudent;
	
	@Autowired
	private StudentsService service;
	
	@MockBean
	private StudentsRepo repo;
	
	@BeforeEach
	void setUp() {
		newStudent = new Student("Lily", 15, "na");
		savedStudent = new Student(1L, "Lily", 15,"na");
	}
	
	@Test
	void testCreate() {
		//given
		//testing data
		
		//when
		Mockito.when(this.repo.save(newStudent)).thenReturn(savedStudent);
		//then
		assertThat(this.service.create(newStudent)).isEqualTo(savedStudent);
	
		//verify
		Mockito.verify(this.repo, Mockito.times(1)).save(newStudent);
	}
	
	@Test
	void testUpdate() {
		
	}
	@Test
	public void testInvalidDelete() {
		//Initial
		Long invalidId = 50L;
		
		//When -- When Id doesn't exist, it should return false ???
		Mockito.when(this.repo.existsById(invalidId)).thenReturn(true);
		
		//Then
		assertThat(this.service.delete(invalidId)).isEqualTo(false);
		
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(invalidId);
	}
}
