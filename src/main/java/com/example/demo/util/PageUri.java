package com.example.demo.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PageUri {

    //Jira Base URL
    public static final String JIRA_BASE_URL = "https://jira-uat.endava.com/";

    //Sessions, User URLS
    public static final String CREATE_SESSION_URL = "rest/auth/latest/session";
    public static final String GET_CURRENT_USER = "rest/auth/latest/session";

    //Project
    public static final String GET_ALL_PROJECTS = "rest/api/2/project";

    //Issue
    public static final String CREATE_ISSUE = "rest/api/2/issue/";
    public static final String DELETE_ISSUE = "rest/api/2/issue/";
    public static final String GET_ALL_ISSUES_ASSIGNED_TO_USER = "rest/api/2/search?jql=project=IAT2 AND assignee=";
    public static final String COMMENT = "/comment";

    public static final String CREATE_SESSION = "/createNewSession";
    public static final String AUTH = "/auth";
    public static final String CURRENT_USER = "/currentUser";
    public static final String PROJECT = "/project";
    public static final String ISSUE = "/issue";
    public static final String CREATE = "/create";
    public static final String DELETE = "/delete/{id}";
    public static final String ASSIGNED_TO_USER = "/getTaskAssignedToUser/{username}";
    public static final String ALL = "/all";
    public static final String GET_PROJECT_BY_KEY = "/key/{projectKey}";
    public static final String DELETE_COMMENT = "/{issueKey}/comment/{commentId}";
    public static final String ADD_COMMENT = "/{issueKey}/comment";
    public static final String ISSUE_PATH = "rest/api/2/issue/";
    public static final String EDIT = "/edit/{issueIdOrKey}";
    public static final String EDIT_ISSUE = "/rest/api/2/issue/";
}
