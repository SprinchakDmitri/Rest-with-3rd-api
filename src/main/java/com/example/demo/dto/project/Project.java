package com.example.demo.dto.project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Project implements Serializable {

    private static final long   serialVersionUID = 331L;


    private String expand;
    private String self;
    private String id;
    private String key;
    private String name;
    private AvatarUrls avatarUrls;
    private String projectTypeKey;

}