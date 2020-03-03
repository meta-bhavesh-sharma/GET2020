package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.metacube.training.model.commands.Plan;
 
@Repository
public interface PlanRepository
        extends JpaRepository<Plan, Long> {
 
}