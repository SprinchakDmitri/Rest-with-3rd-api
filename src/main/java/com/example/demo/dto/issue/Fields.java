package com.example.demo.dto.issue;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Fields {
    @JsonProperty("project")
    private Project project;

    @JsonProperty("summary")
    private String summary;

    @JsonProperty("labels")
    private List<String> labels;

    @JsonProperty("description")
    private String description;

    @JsonProperty("issuetype")
    private IssueType issueType;
}