package my.example.service.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import lombok.extern.slf4j.Slf4j;
import my.example.dao.AbstractJpa;
import my.example.dao.EmployeeDao;
import my.example.jpa.AppDbService;
import my.example.model.Employee;
import my.example.service.EmployeeServiceable;
import my.example.service.qulifier.Repository;

@ApplicationScoped
@Slf4j
@Repository(name = Repository.DATABASE)
public class EmployeeServiceDatabase extends AbstractJpa<Employee> implements EmployeeServiceable {

	// ---- for Unit Test
	private EntityManager em;

	public EmployeeServiceDatabase(EntityManager em) {
		this.setClazz(Employee.class);
		this.em = em;
	}

	// --- after create new class
	@Inject
	protected AppDbService db;

	@Override
	public EntityManager getEm() {
		return (this.em != null) ? em : db.getEm();
	}

	public EmployeeServiceDatabase() {
		this.setClazz(Employee.class);
	}
	
	@Inject
	private EmployeeDao employeeDao;

	@Override
	public void add(Employee employee) {
		try {
			db.begin();
			employeeDao.create(employee);
			db.commit();
		} catch (Exception e) {
			log.error("add Exception", e);
			db.rollback();
			throw e;
		}
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Employee> getEmployees(int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> search(Employee empSearch) {
		// TODO Auto-generated method stub
		return null;
	}
}
