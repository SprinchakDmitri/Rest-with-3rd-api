package com.example.demo.controller;

import com.example.demo.dto.issue.Comment;
import com.example.demo.dto.issue.UpdateIssue;
import lombok.RequiredArgsConstructor;
import com.example.demo.dto.issue.Issue;
import com.example.demo.service.jira.IssuesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.demo.util.PageUri.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ISSUE)
public class IssueController {

    private final IssuesService issuesService;

    @PostMapping(CREATE)
    public ResponseEntity<String> createIssue(@RequestBody Issue issue){
        return ResponseEntity.ok("Issue with ID " + issuesService.createIssue(issue) + " was created");
    }

    @DeleteMapping(DELETE)
    public String deleteIssueById(@PathVariable String id){
        return issuesService.deleteIssueById(id);
    }

    @GetMapping(ASSIGNED_TO_USER)
    public ResponseEntity<String> getIssuesAssignedToUser(@PathVariable String username){
        return issuesService.getIssuesAssignedToUser(username);
    }

    @DeleteMapping(DELETE_COMMENT)
    public String deleteCommentById(@PathVariable String issueKey,@PathVariable String commentId){
        return issuesService.deleteComment(issueKey,commentId);
    }

    @PostMapping(ADD_COMMENT)
    public ResponseEntity<String> addComment( @PathVariable String issueKey,@RequestBody Comment comment ){
         return ResponseEntity.ok("Issue with ID " + issuesService.addComment(comment,issueKey) + " was created");
    }

     @PutMapping(EDIT)
    public ResponseEntity<String> editIssue(@RequestBody UpdateIssue updateIssue, @PathVariable String issueKey) {
        return ResponseEntity.ok(issuesService.editIssue(updateIssue, issueKey));
    }
}
