package com.example.foundationmanagement.controller;
import com.example.foundationmanagement.entity.Nonprofit;
import com.example.foundationmanagement.service.NonprofitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nonprofits")
public class NonprofitController {

    @Autowired
    private NonprofitService nonprofitService;

    @PostMapping
    public ResponseEntity<Nonprofit> createNonprofit(@RequestBody Nonprofit nonprofit) {
        Nonprofit createdNonprofit = nonprofitService.createNonprofit(nonprofit);
        return ResponseEntity.ok(createdNonprofit);
    }

    @GetMapping
    public List<Nonprofit> getAllNonprofits() {
        return nonprofitService.getAllNonprofits();
    }
}

