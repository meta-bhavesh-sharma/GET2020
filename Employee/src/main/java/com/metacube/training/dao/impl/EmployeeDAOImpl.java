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
import com.metacube.training.model.commands.LoginCommands;

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
		session.saveOrUpdate(employeeCommands);
		tx.commit();
		return 	1;	 
	}
	@Override
	public EmployeeCommands getEmpolyee(int id) {
		tx=session.beginTransaction();
		Query query = session.createQuery("from EmployeeCommands where Rid = :id");
		query.setParameter("id", id);
		tx.commit();
		return (EmployeeCommands) query.list().get(0);

	}

	@Override
	public boolean updateEmployee(EmployeeCommands employeeCommand) {
		tx=session.beginTransaction();
		session.update(employeeCommand);
		tx.commit();
			return true;
	}
	@Override
	public List<EmployeeCommands> getAllEmployees(int id) {
		tx=session.beginTransaction();
		Query query1 = session.createSQLQuery("select org from emp where Rid=:id");
		query1.setParameter("id", id);
		String org=(String) query1.list().get(0);
		Query query = session.createQuery("from EmployeeCommands where org=:org");
		query.setParameter("org", org);
		tx.commit();
		return query.list();
	}
	@Override
	public int getId(LoginCommands loginCommands) {
		tx=session.beginTransaction();
		Query query = session.createSQLQuery("select Rid from emp where email = :email AND password =:password");
		query.setParameter("email", loginCommands.getEmail());
		query.setParameter("password", loginCommands.getPassword());
		tx.commit();
		if( query.list().size()==0)
			return 0;
		return (int)query.list().get(0);
	}
	@Override
	public String getImage(int id) {
		tx=session.beginTransaction();
		Query query = session.createSQLQuery("select image from emp where Rid = :id ");
		query.setParameter("id", id);
		tx.commit();
		return (String)query.list().get(0);
	}
	@Override
	public void saveImage(String fileName, int id)
	{
		tx=session.beginTransaction();
		Query query = session.createSQLQuery("update emp set image = :image where  Rid = :id  ;");
		query.setParameter("image",fileName);
		query.setParameter("id",id);
		tx.commit();
	}
}
