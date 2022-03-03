package com.qa.students.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.students.domain.Students;

@Repository
public interface StudentsRepo extends JpaRepository<Students,Long> {
	//custom queries go here
	
	@Query(value = "SELECT * FROM students WHERE age >= 18", nativeQuery = true)
	public abstract List<Students> getAdult();
}
