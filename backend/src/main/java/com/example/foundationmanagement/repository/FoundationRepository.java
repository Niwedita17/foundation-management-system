package com.example.foundationmanagement.repository;

import com.example.foundationmanagement.entity.Foundation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoundationRepository extends JpaRepository<Foundation, Long> {
}

