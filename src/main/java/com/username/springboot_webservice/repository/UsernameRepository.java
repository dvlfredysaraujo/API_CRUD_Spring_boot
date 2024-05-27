package com.username.springboot_webservice.repository;

import com.username.springboot_webservice.entity.Username;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsernameRepository extends JpaRepository<Username, Long> {
    /* This code declares UsernameRepository interface, which extends JpaRepository interface.
     */
}
