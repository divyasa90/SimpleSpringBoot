package com.simple.spring.boot.repository;

import com.simple.spring.boot.entity.Home;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeRepository extends JpaRepository<Home, Long> {
}
