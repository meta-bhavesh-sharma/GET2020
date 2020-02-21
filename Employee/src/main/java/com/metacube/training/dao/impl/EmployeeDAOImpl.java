package com.metacube.training.dao.impl;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.metacube.training.dao.EmployeeDAO;

import com.metacube.training.model.commands.EmployeeCommands;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	 private Session session;
	 private Configuration con;
	 private StandardServiceRegistryBuilder reg;
	 EmployeeCommands employeeCommand;
	 Transaction tx;
	public EmployeeDAOImpl()
	{
		 con =new Configuration().configure().addAnnotatedClass(EmployeeCommands.class);
		 reg=new StandardServiceRegistryBuilder().applySettings(con.getProperties());
		 SessionFactory sf=con.buildSessionFactory(reg.build());
		 session=sf.openSession();
		}
	@Override
	public 	int addEmpolyee(EmployeeCommands employeeCommands)
	{
		tx=session.beginTransaction();
		session.save(employeeCommands);
		tx.commit();
		return 	1;	 
	}
	@Override
	public EmployeeCommands getEmpolyee(int id) {
		Query query = session.createQuery("from EmployeeCommands where Rid = :id");
		query.setParameter("id", id);
		return (EmployeeCommands) query.list().get(0);
	}

	@Override
	public boolean updateEmployee(EmployeeCommands employeeCommand) {
		session.update(employeeCommand);

			return true;
	}
	@Override
	public List<EmployeeCommands> getAllEmployees(int id) {
		System.out.println(id);
		Query query1 = session.createSQLQuery("select org from emp where Rid=:id");
		query1.setParameter("id", id);
		String org=(String) query1.list().get(0);
		Query query = session.createQuery("from EmployeeCommands where org=:org");
		query.setParameter("org", org);
		return query.list();
	}
}
