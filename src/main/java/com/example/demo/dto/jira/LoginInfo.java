package com.example.demo.dto.jira;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginInfo {
    private String lastFailedLoginTime;
    private String previousLoginTime;
    private int loginCount;
    private int failedLoginCount;


    @Override
    public String toString() {
        return "LoginInfo{" +
                "lastFailedLoginTime='" + lastFailedLoginTime + '\'' +
                ", previousLoginTime='" + previousLoginTime + '\'' +
                ", loginCount=" + loginCount +
                ", failedLoginCount=" + failedLoginCount +
                '}';
    }
}