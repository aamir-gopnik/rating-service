package com.gopnik.feedbackservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Option {

    private int optionId;
    private String optionName;
    private int weightage;
}
