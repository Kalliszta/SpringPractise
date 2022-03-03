package com.qa.students.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.students.domain.Students;

@Repoository
public interface StudentsRepo extends JpaRepository<Students,Long> {
	//custom queries go here
}
