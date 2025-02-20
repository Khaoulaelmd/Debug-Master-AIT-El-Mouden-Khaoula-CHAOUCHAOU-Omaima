package com.example.courrierservice.controller;



import com.example.courrierservice.entity.Courier;
import com.example.courrierservice.model.Admine;
import com.example.courrierservice.model.AdmineFeign;
import com.example.courrierservice.model.Employee;
import com.example.courrierservice.model.EmployeeFeign;
import com.example.courrierservice.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/couriers")
public class CourierController {

    @Autowired
    private CourierService courierService;
    @Autowired
    private EmployeeFeign employeeFeign;
    @Autowired
    private AdmineFeign admineFeign;

    @GetMapping
    public List<Courier> getAllCouriers() {
        return courierService.getAllCouriers();
    }

    @GetMapping("/{id}")
    public Optional<Courier> getCourierById(@PathVariable Long id) {
        return courierService.getCourierById(id);
    }

    @PostMapping
    public Courier createCourier(@RequestBody Courier courier) {

        return courierService.saveCourier(courier);
    }
    @DeleteMapping("/{id}")
    public void deleteCourier(@PathVariable Long id) {
        courierService.deleteCourier(id);
    }

    @GetMapping("/statut/{statut}")
    public List<Courier> getCouriersByStatut(@PathVariable Courier statut) {
        return courierService.getCouriersByStatut(statut);
    }
}
