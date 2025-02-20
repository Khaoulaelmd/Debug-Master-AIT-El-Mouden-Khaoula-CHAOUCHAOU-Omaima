package com.example.userservice.service;

import com.example.userservice.entity.Admin;
import com.example.userservice.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public String getAdminServiceStatus() {
        return "Admin Service is up and running!";
    }
}
