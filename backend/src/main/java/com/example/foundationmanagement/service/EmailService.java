package com.example.foundationmanagement.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailService {

    private final List<String> sentEmails = new ArrayList<>();

    public void sendEmail(String recipientEmail, String subject, String body) {
        System.out.println("Sending email to: " + recipientEmail);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
        String mail="Sending email to: " + recipientEmail+ ", Subject: " + subject + ", Body: " + body;
        sentEmails.add(mail);
    }

    public List<String> getAllSentEmails() {
        return sentEmails;
    }
}

