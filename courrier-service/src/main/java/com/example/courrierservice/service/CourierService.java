package com.example.courrierservice.service;


import com.example.courrierservice.entity.Courier;
import com.example.courrierservice.entity.StatutCourier;
import com.example.courrierservice.model.Admine;
import com.example.courrierservice.model.AdmineFeign;
import com.example.courrierservice.model.Employee;
import com.example.courrierservice.model.EmployeeFeign;
import com.example.courrierservice.repository.CourierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourierService {

    @Autowired
    private CourierRepository courierRepository;
    @Autowired
    private EmployeeFeign employeeFeign;
    @Autowired
    private AdmineFeign admineFeign;

    public List<Courier> getAllCouriers() {
        return courierRepository.findAll();
    }

    public Optional<Courier> getCourierById(Long id) {
        return courierRepository.findById(id);
    }

    public Courier saveCourier(Courier courier) {
        Employee employee = employeeFeign.getEmployee(courier.getIdEmployee());

        if (employee == null) {
            throw new RuntimeException("Employé non trouvé avec l'ID : " + courier.getIdEmployee());
        }
        courier.setEmployee(employee);

        Admine admine =admineFeign.getAdmine(courier.getIdAdmine());
        if (admine == null) {
            throw new RuntimeException("Admin non trouvé avec ID :");
        }
        courier.setAdmine(admine);;
        return courierRepository.save(courier);
    }

    public void deleteCourier(Long id) {
        courierRepository.deleteById(id);
    }

    public List<Courier> getCouriersByStatut(Courier statut) {
        return courierRepository.findByStatut(statut);
    }

}
