package com.example.courrierservice.model;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "EMPLOYE-SERVICE")
public interface EmployeeFeign {
    @GetMapping("/api/employees/{id}")
    Employee getEmployee(@PathVariable("id") Long id);

}
