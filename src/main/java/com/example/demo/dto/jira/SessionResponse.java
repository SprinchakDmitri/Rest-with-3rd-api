package com.example.demo.dto.jira;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SessionResponse {

    private LoginInfo loginInfo;
    private Session session;


    @Override
    public String toString() {
        return "CreateSessionResponse{" +
                "loginInfo=" + loginInfo +
                ", session=" + session +
                '}';
    }
}
