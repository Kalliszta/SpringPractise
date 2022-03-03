package com.qa.students.domain;

import javax.persistence.*;

import lombok.*;

@Entity //this marks this class as the table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Students {
	
	//columns for the the table
	
	@Id //marks it as the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //makes it auto-increment
	private Long id;
	
	private String name;
	private int age;
	private String phoneNumber;
	
	
	public Students(String name, int age, String phoneNumber) {
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
	}
	
	
}

