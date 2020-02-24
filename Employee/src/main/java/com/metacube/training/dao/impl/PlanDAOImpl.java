package com.metacube.training.dao.impl;

import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.dao.PlanDAO;
import com.metacube.training.model.commands.EmployeeCommands;
import com.metacube.training.model.commands.Plan;
import com.metacube.training.model.commands.PlanCommand;
import com.metacube.training.model.commands.VehicleCommand;

@Repository
public class PlanDAOImpl implements PlanDAO{
	 private Session session;
	 private Configuration con;
	 private StandardServiceRegistryBuilder reg;
	 EmployeeCommands employeeCommand;
	 Transaction tx;
	
	public PlanDAOImpl(DataSource dataSource) {
		 con =new Configuration().configure().addAnnotatedClass(Plan.class);
		 reg=new StandardServiceRegistryBuilder().applySettings(con.getProperties());
		 SessionFactory sf=con.buildSessionFactory(reg.build());
		 session=sf.openSession();
	}

	@Override
	public boolean purchase(Plan plan) {
		tx=session.beginTransaction();
		session.saveOrUpdate(plan);
		tx.commit();
		return true;
	}
	
	@Override
	public boolean check(int id)
	{
		tx=session.beginTransaction();
		Query query=session.createQuery("from Plan where rid=:id ");
		query.setParameter("id", id);
		if(query.list().size()==0)
		{
			tx.commit();
			return false;
		}
		else
		{
			tx.commit();
			return true;
		}
	}

}
