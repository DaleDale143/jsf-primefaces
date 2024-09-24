package my.example.service;

import java.util.List;

import my.example.dao.OrmDao;
import my.example.model.Employee;


public interface EmployeeServiceable extends OrmDao<Employee> {

	public void add(Employee employee);

	public List<Employee> search(Employee empSearch);

	public int delete(String id);

	public void update(Employee employee);

	public List<Employee> getEmployees(int size);
}