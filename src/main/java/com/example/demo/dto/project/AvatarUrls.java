package com.example.demo.dto.project;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AvatarUrls implements Serializable {

    private static final long   serialVersionUID = 331L;

    @JsonProperty("16x16")
    private String avatar16x16;

    @JsonProperty("24x24")
    private String avatar24x24;

    @JsonProperty("32x32")
    private String avatar32x32;

    @JsonProperty("48x48")
    private String avatar48x48;
}
