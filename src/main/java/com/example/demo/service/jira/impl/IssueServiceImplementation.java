package com.example.demo.service.jira.impl;


import com.example.demo.dto.issue.Comment;
import com.example.demo.dto.issue.UpdateIssue;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import com.example.demo.dto.issue.CreateIssueResponse;
import com.example.demo.dto.issue.Issue;
import com.example.demo.exception.EmptyFieldException;
import com.example.demo.service.jira.IssuesService;
import com.example.demo.util.CheckIfObjectNullOrEmpty;

import static com.example.demo.util.PageUri.*;

@Service
@RequiredArgsConstructor
public class IssueServiceImplementation implements IssuesService {

    private final JiraServiceImplementation jiraServiceImplementation;
    private final RestTemplate restTemplate;

    @Override
    public String createIssue(Issue issue) {
        if (CheckIfObjectNullOrEmpty.checkIfIssueFieldsIsNullOrEmpty(issue)) {
            HttpEntity request = new HttpEntity(issue, getHeader());
            return restTemplate.exchange(JIRA_BASE_URL + CREATE_ISSUE, HttpMethod.POST, request,
                CreateIssueResponse.class).getBody().getId();
        } else {
            try {
                throw new EmptyFieldException("Please fill all necessary fields");
            } catch (HttpClientErrorException httpClientErrorException){
                return "You are not authorized, please sign in with your JIRA account";
            }
            catch (EmptyFieldException e) {
                e.printStackTrace();
                return e.getMessage();
            }
        }
    }

    @Override
    public String deleteIssueById(String id) {
        HttpEntity request = new HttpEntity(getHeader());
        try {
            restTemplate.exchange(JIRA_BASE_URL + DELETE_ISSUE.concat(id),
                HttpMethod.DELETE, request,
                String.class);
            return "Issue with id - " + id + " was deleted successfully";
        } catch (HttpClientErrorException clientErrorException){
            return "You don't have permission to delete this issue";
        }
        catch (Exception  e) {
            return "No Issue with ID " + id;
        }



    }

    @Override
    public ResponseEntity<String> getIssuesAssignedToUser(String name) {
        String url = JIRA_BASE_URL.concat(GET_ALL_ISSUES_ASSIGNED_TO_USER).concat(name);
        HttpEntity request = new HttpEntity<>(getHeader());
        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        return result;
    }

    @Override
    public String deleteComment(String projectKey, String commentId){
        HttpEntity request = new HttpEntity(getHeader());
        try {
            restTemplate.exchange(JIRA_BASE_URL + ISSUE_PATH + projectKey + COMMENT + "/" + commentId,
                HttpMethod.DELETE, request,
                String.class);
            return "Comment with id - " + commentId + " was deleted successfully";
        } catch (HttpClientErrorException clientErrorException){
            return "You don't have permission to delete this comment";
        }
        catch (Exception  e) {
            return "No comment with ID " + commentId;
        }
    }

     @Override
    public String addComment(Comment comment, String issueKey) {
        HttpEntity request = new HttpEntity(comment, getHeader());
        try {
            restTemplate.exchange(JIRA_BASE_URL + ISSUE_PATH + issueKey + COMMENT,
                    HttpMethod.POST, request,
                    String.class);
            return "Added a comment to issue with key - " + issueKey;
        } catch (HttpClientErrorException clientErrorException) {
            return "Something went wrong";
        }
    }

    @Override
    public String editIssue(UpdateIssue updateIssue, String issueIdOrKey) {
        HttpEntity request = new HttpEntity(updateIssue, getHeader());
        try {
            restTemplate.exchange(JIRA_BASE_URL + EDIT_ISSUE.concat(issueIdOrKey), HttpMethod.PUT,
                    request,
                    String.class);
            return "Issue with id(key) - " + issueIdOrKey + " was edited successfully";
        } catch (HttpClientErrorException httpClientErrorException) {
            return "Something went wrong";
        }
    }


    private HttpHeaders getHeader() {
        jiraServiceImplementation.getSession();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("cookie", "JSESSIONID=" + jiraServiceImplementation.sessionValue.getSessionValue());
        return headers;
    }
}
