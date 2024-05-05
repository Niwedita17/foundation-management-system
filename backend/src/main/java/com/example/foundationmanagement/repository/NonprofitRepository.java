package com.example.foundationmanagement.repository;

import com.example.foundationmanagement.entity.Nonprofit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NonprofitRepository extends JpaRepository<Nonprofit, Long> {
}

