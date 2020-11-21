package com.example.demo.service.jira;

import com.example.demo.dto.project.Project;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

public interface ProjectService {

    ArrayList getAllProjects();

    ResponseEntity<Project> getProjectByKey(String projectKey);
}
