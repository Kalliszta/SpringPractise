package com.qa.students.service;

import java.util.List;

public interface ServiceInterface<T> {
	
	T create(T t);
	
	List<T> readAll();
	
	T readById(Long id);
	
	T update(Long id,T t);
	
	boolean delete(Long id); //returns true if successfully deleted
	
}
