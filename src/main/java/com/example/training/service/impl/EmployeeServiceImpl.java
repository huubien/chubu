package com.example.training.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.training.dao.EmployeeDao;
import com.example.training.model.Employees;
import com.example.training.service.EmployeeService;

@Service("postService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao empDao;

	@Override
	public void createEmployee(Employees emp) {
		this.empDao.save(emp);

	}

	@Override
	public void deleteEmployee(Long empId) {
		this.empDao.delete(empId);

	}

	@Override
	public void updateEmployee(Employees emp) {
		this.updateEmployee(emp);

	}

	@Override
	public Map<String, Object> findEmp(Long empId) {
		Map<String, Object> attributes = new HashMap<>();
		Employees emp = this.empDao.find(empId);
		attributes.put("empt", emp);
		return attributes;
	}

	@Override
	public Map<String, Object> findAllEmp() {
		Map<String, Object> attributes = new HashMap<>();
		List<Employees> allEmps = this.empDao.findAll();
		attributes.put("emps", allEmps);
		attributes.put("empDto", new Employees());
		return attributes;
	}

}
