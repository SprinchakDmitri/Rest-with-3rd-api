package com.example.demo.service.jira;

import com.example.demo.dto.jira.CurrentUser;
import org.springframework.http.ResponseEntity;

public interface JiraService {

    void getSession();

    ResponseEntity<CurrentUser> getCurrentUser();
}
