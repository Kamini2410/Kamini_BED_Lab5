package com.example.employeemanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeemanagementsystem.entity.Employee;
import com.example.employeemanagementsystem.repository.EmployeeRepository;



@Service
public class EmpServiceImpl implements EmployeeService {
	

	private EmployeeRepository empRepository;

	@Autowired
	public void empServiceImpl(EmployeeRepository theempRepository) {
		empRepository = theempRepository;
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> theemp = empRepository.findAll();
		return theemp;
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = empRepository.findById(theId);

		Employee theemp = null;

		if (result.isPresent()) {
			theemp = result.get();
		} else {
			
			throw new RuntimeException("Did not find employee id - " + theId);
		}

		return theemp;
	}

	@Override
	public void save(Employee theemp) {
		empRepository.save(theemp);
		
	}

	@Override
	public void deleteById(int theId) {
		empRepository.deleteById(theId);
		
	}

}
