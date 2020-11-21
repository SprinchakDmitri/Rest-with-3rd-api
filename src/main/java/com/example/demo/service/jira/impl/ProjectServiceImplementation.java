package com.example.demo.service.jira.impl;

import com.example.demo.dto.project.Project;
import lombok.RequiredArgsConstructor;
import com.example.demo.dto.jira.SessionValue;
import com.example.demo.service.jira.ProjectService;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;

import static com.example.demo.util.PageUri.GET_ALL_PROJECTS;
import static com.example.demo.util.PageUri.JIRA_BASE_URL;

@Service
@RequiredArgsConstructor
public class ProjectServiceImplementation implements ProjectService {

    private final JiraServiceImplementation jiraServiceImplementation;
    private final RestTemplate restTemplate;

    @Override
    public ArrayList getAllProjects() {
        jiraServiceImplementation.getSession();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("cookie", "JSESSIONID=" + jiraServiceImplementation.sessionValue.getSessionValue());
        HttpEntity request = new HttpEntity<>(headers);
        return restTemplate.exchange(JIRA_BASE_URL + GET_ALL_PROJECTS, HttpMethod.GET, request, ArrayList.class)
            .getBody();
    }

    @Override
    public ResponseEntity<Project> getProjectByKey(String projectKey){
        jiraServiceImplementation.getSession();
        HttpHeaders headers = new HttpHeaders();
        headers.set("cookie", "JSESSIONID=" + jiraServiceImplementation.sessionValue.getSessionValue());
        HttpEntity request = new HttpEntity<>(headers);
        return  restTemplate.exchange(JIRA_BASE_URL + GET_ALL_PROJECTS +"/" + projectKey,
                                       HttpMethod.GET, request, Project.class);

    }
}
