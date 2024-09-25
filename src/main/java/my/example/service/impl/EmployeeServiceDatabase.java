package my.example.service.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import my.example.dao.EmployeeDao;
import my.example.jpa.AppDbService;
import my.example.model.Employee;
import my.example.service.EmployeeServiceable;
import my.example.service.qulifier.Repository;

@ApplicationScoped
@Repository(name = Repository.DATABASE)
public class EmployeeServiceDatabase implements EmployeeServiceable {

	// --- after create new class
	@Inject
	protected AppDbService db;

	
	@Inject
	EmployeeDao employeeDao;


	@Override
	public void add(Employee employee) {
		try {
			db.begin();
			employeeDao.create(employee);
			db.commit();
		} catch (Exception e) {
			db.rollback();
			throw e;
		}
	}

	@Override
	public List<Employee> search(Employee empSearch) {
		return employeeDao.findAll();
	}

	@Override
	public void delete(String id) {
		try {
			db.begin();
			employeeDao.deleteById(id);
			db.commit();
		} catch (Exception e) {
			db.rollback();
			throw e;
		}
	}
	
	@Override
	public void update (Employee employee) {
		try {
			db.begin();
			employeeDao.update(employee);
			db.commit();
		} catch (Exception e) {
			db.rollback();
			throw e;
		}
	}

	@Override
	public List<Employee> getEmployees(int size) {
	    return employeeDao.findAll();
	}



}
