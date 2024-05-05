package com.example.foundationmanagement.service;

import com.example.foundationmanagement.entity.Nonprofit;
import com.example.foundationmanagement.repository.NonprofitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NonprofitService {

    @Autowired
    private NonprofitRepository nonprofitRepository;

    public Nonprofit createNonprofit(Nonprofit nonprofit) {
        return nonprofitRepository.save(nonprofit);
    }

    public List<Nonprofit> getAllNonprofits() {
        return nonprofitRepository.findAll();
    }
}
