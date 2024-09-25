package my.example.dao;

import java.util.List;

import my.example.model.Employee;

public interface EmployeeDao extends OrmDao<Employee> {
	
	public List<Employee> findByName(String name);
	
}
