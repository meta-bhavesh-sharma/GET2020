package com.metacube.training.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.StudentDAO;
import com.metacube.training.model.commands.StudentCommands;
import com.metacube.training.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO StudentDAO;
	
	
	@Override
	public int addEmpolyee(StudentCommands StudentCommands) {
		StudentDAO.addStudent(StudentCommands);
		
		return 0;
	}

	/*@Override
	public StudentCommands getEmpolyee(int id) {
		return StudentDAO.getStudent(id);
	}*/

	@Override
	public List<StudentCommands> getAllStudents() {
		
		return StudentDAO.getAllStudents();
	}

}
