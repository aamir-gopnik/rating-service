package com.gopnik.feedbackservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class SurveyResponse {

    private int responseId;

    private int surveyId;

    private String surveyName;

    private List<Answer> surveyAnswers;

    private int responseCount;

}
