package com.example.foundationmanagement.controller;
import com.example.foundationmanagement.entity.Foundation;
import com.example.foundationmanagement.service.FoundationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foundations")
public class FoundationController {

    @Autowired
    private FoundationService foundationService;

    @PostMapping
    public ResponseEntity<Foundation> createFoundation(@RequestBody Foundation foundation) {
        Foundation createdFoundation = foundationService.createFoundation(foundation);
        return ResponseEntity.ok(createdFoundation);
    }

    @GetMapping
    public List<Foundation> getAllFoundations() {
        return foundationService.getAllFoundations();
    }
}

