package com.qa.students.domain;

import java.util.Objects;

import javax.persistence.*;

@Entity //this marks this class as the table
@Table
public class Students {
	
	//columns for the the table
	
	@Id //marks it as the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //makes it auto-increment
	private Long id;
	
	private String name;
	private int age;
	private String phoneNumber;
	
	
	public Students() {
		
	}
	
	public Students(String name, int age, String phoneNumber) {
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
	}
	
	public Students(Long id, String name, int age, String phoneNumber) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(age, id, name, phoneNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Students other = (Students) obj;
		return age == other.age && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(phoneNumber, other.phoneNumber);
	}
	
	
	
}
