package com.example.training.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.example.training.model.Employees;

@Mapper
public interface EmployeeDao {
	
	void save(Employees emp);
	
	void delete(Long empId);
	
	void update(Employees emp);
	
	Employees find(Long empId);
	
	List<Employees> findAll();
	
}