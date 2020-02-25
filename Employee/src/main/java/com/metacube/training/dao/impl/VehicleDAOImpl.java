package com.metacube.training.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metacube.training.dao.PlanDAO;
import com.metacube.training.dao.VehicleDAO;
import com.metacube.training.model.commands.EmployeeCommands;
import com.metacube.training.model.commands.VehicleCommand;

@Repository
public class VehicleDAOImpl implements VehicleDAO {
	
	 @Autowired
	 PlanDAO planDAO;
	 
	 private Session session;
	 private Configuration con;
	 private StandardServiceRegistryBuilder reg;
	 EmployeeCommands employeeCommand;
	 Transaction tx;
	public VehicleDAOImpl()
	{
		 con =new Configuration().configure().addAnnotatedClass(VehicleCommand.class);
		 reg=new StandardServiceRegistryBuilder().applySettings(con.getProperties());
		 SessionFactory sf=con.buildSessionFactory(reg.build());
		 session=sf.openSession();
		}
	
	public String addVehicle(VehicleCommand vehicleCommand)
	{
		tx=session.beginTransaction();
		session.saveOrUpdate(vehicleCommand);
		tx.commit();
		tx=session.beginTransaction();
		Query query=session.createSQLQuery("select type from veichle where rid =:id");
		query.setParameter("id",vehicleCommand.getEid());
		String result=(String)query.list().get(0);
		tx.commit();
		return result;
	}

	@Override
	public int check(int id) {
		tx=session.beginTransaction();
		Query query=session.createQuery("from VehicleCommand where rid=:id ");
		query.setParameter("id", id);
		if (query.list().size() == 0) {
			tx.commit();
			return 0;
		} else if (planDAO.check(id)) {
			return 1;
		} else {
			tx.commit();
			return 2;
		}
	}

	@Override
	public String getType(int id) {
		tx=session.beginTransaction();
		Query query=session.createSQLQuery("select type from veichle where rid=:id");
		query.setParameter("id", id);
		String result=(String) query.list().get(0);
		return result;
	}
}
