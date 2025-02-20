package com.example.courrierservice.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "user-service", url = "http://localhost:8082/api/users")
public interface UserFeignClient {

    @GetMapping("/validate")
    boolean validateUser(@RequestHeader("Authorization") String token);
}