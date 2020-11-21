package com.example.demo.service.jira;
import com.example.demo.dto.issue.Comment;
import com.example.demo.dto.issue.Issue;
import com.example.demo.dto.issue.UpdateIssue;
import org.springframework.http.ResponseEntity;

public interface IssuesService {

   String createIssue(Issue issue);

   String deleteIssueById(String id);

   String addComment(Comment comment, String issueKey);

   String deleteComment(String issueKey, String commentId);

   String editIssue(UpdateIssue updateIssue, String issueIdOrKey);

   ResponseEntity<String> getIssuesAssignedToUser(String name);


}
