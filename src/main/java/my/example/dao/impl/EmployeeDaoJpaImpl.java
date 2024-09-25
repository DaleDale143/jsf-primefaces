package my.example.dao.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import my.example.dao.EmployeeDao;
import my.example.jpa.AppDbService;
import my.example.model.Employee;

@ApplicationScoped
public class EmployeeDaoJpaImpl extends AbstractJpa<Employee> implements EmployeeDao {
	// ---- for Unit Test
	private EntityManager em;

	public EmployeeDaoJpaImpl(EntityManager em) {
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

	public EmployeeDaoJpaImpl() {
		this.setClazz(Employee.class);
	}
	
	// ---- implement DAO method

	public List<Employee> findByName(String name) {
		StringBuilder sb = null;
		TypedQuery<Employee> query = null;
		sb = new StringBuilder();
		sb.append("SELECT e FROM Employee e ");
		sb.append("WHERE e.firstName = :firstName ");
		query = this.getEm().createQuery(sb.toString(), Employee.class).setParameter("firstName", name);
		return query.getResultList();
	}
}
