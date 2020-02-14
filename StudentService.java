package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.commands.StudentCommands;
/**
 * Service contains methods to Student operations
 * @author bhavesh
 *
 */
public interface StudentService {

	/**
	 * 
	 * @param StudentCommands
	 * @return
	 */
	int addEmpolyee(StudentCommands StudentCommands);

	/**
	 * 
	 * @param id
	 * @return
	 */
	//StudentCommands getEmpolyee(int id);



	/**
	 * 
	 * @return
	 */
	List<StudentCommands> getAllStudents();


}
