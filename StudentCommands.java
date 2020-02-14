package com.metacube.training.model.commands;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StudentCommands {

	@NotBlank
	@Email//(message = "{badEmail}")
	private String email;
	
	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@NotBlank
	private String fatherName;
	
	@Min(1)
	@Max(100)
	@NotNull
	private int age;
	
	@Min(1)
	@Max(12)
	@NotNull
	private int studentClass;
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLastName() {
		return lastName;
	}
	
	
	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	public int getStudentClass() {
		return this.studentClass;
	}

	public void setStudentClass(Integer studentClass) {
		this.studentClass = studentClass;
	}
}
