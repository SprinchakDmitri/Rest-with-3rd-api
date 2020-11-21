package com.example.demo.dto.issue;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reporter {

    @JsonProperty("name")
    private String name;

    @JsonProperty("set")
    public Set set;
}
