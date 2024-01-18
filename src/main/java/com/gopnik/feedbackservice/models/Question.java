package com.gopnik.feedbackservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Question {

    private int questionId;

    private String questionName;

    private Set<Option> optionSet;

}
