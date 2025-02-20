package com.example.userservice.repository;

import com.example.userservice.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository <Admin ,Long> {
}
