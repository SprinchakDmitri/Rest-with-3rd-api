package com.example.demo.dto.issue;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class Update {
    @JsonProperty("summary")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Summary> summary;

    @JsonProperty("description")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Description> description;

    @JsonProperty("issuetype")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<IssueType> issueType;

    @JsonProperty("priority")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Priority> priority;

    @JsonProperty("reporter")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Reporter> reporter;

    @JsonProperty("assignee")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Assignee> assignee;

    @JsonProperty("components")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Component> components;
}