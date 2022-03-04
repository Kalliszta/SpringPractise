package com.qa.students.rest;

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
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.students.domain.Student;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:scema-test.sql","classpath:data-test.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles(profiles = "test")
public class StudentControllerIntegrationTest {
	@Autowired
	private MockMvc mock;
	
	@Autowired
	private ObjectMapper jsonifier; //java object to json
	
	@Test
	void testCreate() throws Exception {
		Student testStudent = new Student("Lily", 15, "na");
		Student expectedStudent = new Student(1L,"Lily", 15, "na");
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.POST, "https://localhost:8080/create").contentType(MediaType.APPLICATION_JSON).content(jsonifier.writeValueAsString(testStudent)).accept(MediaType.APPLICATION_JSON); //don't need contentType and accept for requests with no RequestBody
		
	
	}
}
