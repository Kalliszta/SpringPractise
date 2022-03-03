package com.qa.students.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.students.domain.Students;

@Repository
public interface StudentsRepo extends JpaRepository<Students,Long> {
	//custom queries go here
}
