package com.example.demo.controller;


import com.example.demo.dto.project.Project;
import lombok.RequiredArgsConstructor;
import com.example.demo.service.jira.impl.ProjectServiceImplementation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static com.example.demo.util.PageUri.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(PROJECT)
public class ProjectController {

    private final ProjectServiceImplementation projectServiceImplementation;

    @GetMapping(ALL)
    public ResponseEntity<String> getAllProjects() {
        return ResponseEntity.ok("You currently assigned to the " +
                                 projectServiceImplementation.getAllProjects().size() +
                                 " projects");
    }

    @GetMapping(GET_PROJECT_BY_KEY)
    public ResponseEntity<Project> getProjectByKey(@PathVariable String projectKey){
        return projectServiceImplementation.getProjectByKey(projectKey);
    }
}
