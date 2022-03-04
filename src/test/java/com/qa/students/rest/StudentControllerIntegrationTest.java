package com.qa.students.rest;

import java.util.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.students.domain.Student;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:schema-test.sql","classpath:data-test.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles(profiles = "test")
//@Disabled //used to ignore/disable class
public class StudentControllerIntegrationTest {
	
	//used to mock sending requests
	@Autowired
	private MockMvc mock;
	
	@Autowired
	private ObjectMapper jsonifier; //java object to json
	
	@Test
	void testCreate() throws Exception {
		Student testStudent = new Student(0L,"Lily", 15, "na");
		Student expectedStudent = new Student(5L,"Lily", 15, "na");
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.POST, "https://localhost:8080/student/create").contentType(MediaType.APPLICATION_JSON).content(jsonifier.writeValueAsString(testStudent)).accept(MediaType.APPLICATION_JSON); //don't need contentType and accept for requests with no RequestBody
		
		ResultMatcher status = MockMvcResultMatchers.status().isCreated();
		ResultMatcher content = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(expectedStudent));
	
		this.mock.perform(mockRequest).andExpect(status).andExpect(content);
	}
	
	@Test
	void testReadAll() throws Exception {
		List<Student> expected = Arrays.asList(
				new Student(1L, "Bob", 17, "+021"), 
				new Student(2L, "Millie", 15,"+026"),
				new Student(3L, "Lily", 19,"+028"),
				new Student(4L, "Billy", 11,"+020"));
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET, "https://localhost:8080/student/getAll");
		
		ResultMatcher status = MockMvcResultMatchers.status().isOk();
		ResultMatcher content = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(expected));
	
		this.mock.perform(mockRequest).andExpect(status).andExpect(content);
	}
	
	
}
