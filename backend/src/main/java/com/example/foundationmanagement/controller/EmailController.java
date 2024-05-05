package com.example.foundationmanagement.controller;

import com.example.foundationmanagement.entity.Nonprofit;
import com.example.foundationmanagement.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class EmailController {

    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/emails/send")
    public void sendEmailToNonprofits(@RequestBody List<Nonprofit> nonprofits) {
        for (Nonprofit nonprofit : nonprofits) {
            String emailBody = String.format("Sending money to nonprofit %s at address %s on %s",
                    nonprofit.getName(), nonprofit.getAddress(), LocalDate.now());
            emailService.sendEmail(nonprofit.getEmail(), "Funding Notification", emailBody);
        }
    }

    @GetMapping("/emails")
    public List<String> getAllSentEmails() {
        // Assuming EmailService maintains a list of sent emails
        return emailService.getAllSentEmails();
    }

}
