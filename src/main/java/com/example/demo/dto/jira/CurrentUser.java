package com.example.demo.dto.jira;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrentUser {

    private String self;
    private String name;
    private LoginInfo loginInfo;


    @Override
    public String toString() {
        return "CurrentUser{" +
                "self='" + self + '\'' +
                ", name='" + name + '\'' +
                ", loginInfo=" + loginInfo +
                '}';
    }
}
