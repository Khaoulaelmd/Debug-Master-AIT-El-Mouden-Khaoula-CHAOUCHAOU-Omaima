package com.example.courrierservice.model;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ADMIN-SERVICE")
public interface AdmineFeign {
    @GetMapping("/api/admin/{id}")
    Admine getAdmine(@PathVariable("id") Long id);

}