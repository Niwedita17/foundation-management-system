package com.example.foundationmanagement.service;

import com.example.foundationmanagement.entity.Foundation;
import com.example.foundationmanagement.repository.FoundationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoundationService {

    @Autowired
    private FoundationRepository foundationRepository;

    public Foundation createFoundation(Foundation foundation) {
        return foundationRepository.save(foundation);
    }

    public List<Foundation> getAllFoundations() {
        return foundationRepository.findAll();
    }
}
