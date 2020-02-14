package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.commands.StudentCommands;

public interface StudentDAO {

	/**
	 * 
	 * @param StudentsCommands
	 * @return
	 */
	int addStudent(StudentCommands StudentsCommands);

	/**
	 * 
	 * @param id
	 * @return
	 */

	/**
	 * 
	 * @return
	 */
	public List<StudentCommands> getAllStudents();

}
