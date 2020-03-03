package com.metacube.training.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.commands.Plan;
import com.metacube.training.model.commands.UserCommands;

@Repository
public interface UserRepo extends JpaRepository<UserCommands, Long>{

	 Optional<UserCommands> findByEmail(String usernam);

}
