package com.example.demo.controller;

import lombok.RequiredArgsConstructor;

import com.example.demo.dto.jira.CurrentUser;
import com.example.demo.service.jira.impl.JiraServiceImplementation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.util.PageUri.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(CREATE_SESSION)
public class JiraController {

    private final JiraServiceImplementation jiraServiceImplementation;

    @PostMapping(AUTH)
    public ResponseEntity<String> createSession() {
        jiraServiceImplementation.getSession();
        return ResponseEntity.ok("Current session was fetched");
    }

    @GetMapping(CURRENT_USER)
    public ResponseEntity<String> getCurrentUser() {
        return ResponseEntity.ok("Hello " + jiraServiceImplementation.getCurrentUser().getBody().getName()
        + " welcome back to JIRA!");
    }
}
