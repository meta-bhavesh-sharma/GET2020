package com.metacube.training.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.commands.EmployeeCommands;
 
@Repository
public interface EmployeeRepository
        extends JpaRepository<EmployeeCommands, Long> {
	Optional<EmployeeCommands> findByEmail(String email);

	List<EmployeeCommands> findByOrg(String org);
	
 
}
