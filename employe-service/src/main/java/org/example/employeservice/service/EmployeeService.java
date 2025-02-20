package org.example.employeservice.service;



import lombok.Value;
import org.example.employeservice.entity.Employe;
import org.example.employeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private RestTemplate restTemplate;

    private String aiServiceUrl;
    public List<Employe> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employe> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employe saveEmployee(Employe employe) {
        return employeeRepository.save(employe);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<Employe> getEmployeesByDepartment(String departmentName) {
        return employeeRepository.findByDepartment_Nom(departmentName);
    }
}
