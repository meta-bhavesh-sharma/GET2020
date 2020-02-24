package com.metacube.training.dao;

import com.metacube.training.model.commands.Plan;


public interface PlanDAO {
	/**
	 * 
	 * @param plan
	 * @return
	 */
	boolean purchase(Plan plan);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	boolean check(int id);

}
